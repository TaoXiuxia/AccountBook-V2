package com.taoxiuxia.controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taoxiuxia.exception.BusinessException;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.model.User;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.service.IUserService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.DateTimeUtil;
import com.taoxiuxia.util.EmailUtil;
import com.taoxiuxia.util.PasswordUtil;
import com.taoxiuxia.util.StringTools;

import checkcode.patchca.color.SingleColorFactory;
import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.service.ConfigurableCaptchaService;
import checkcode.patchca.utils.encoder.EncoderHelper;

@Controller
@RequestMapping("/userController")
public class UserController {
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	private IUserService userService;
	
	private IItemService itemService;

	private IPayMethodService payMethodService;
	

	/**
	 * 注册页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUserRegister")
	public String showUserRegister(Model model) {
		return "pages/userRegister";
	}
	
	/**
	 * 激活页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUserActive")
	public String showUserActive(Model model) {
		return "pages/userActive";
	}
	
	/**
	 * 登陆界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUserLogin")
	public String showUserLogin(Model model) {
		return "pages/userLogin";
	}

	/**
	 * 注册第一步，判断是否已经注册（根据邮箱），
	 * 		已注册 已激活  -> 请直接登录
	 * 		已注册 未激活  -> 请前往激活
	 * 		未注册 		-> 向数据库中插入数据
	 * @param session
	 * @param userName
	 * @param email
	 * @param password
	 * @param checkCode
	 * @return
	 */
	@RequestMapping(value = "/register.action", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String ,Object> register(HttpSession session, String userName, String email, String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 0:未注册;1:已注册，未激活;2:已注册，已激活
		int emailState = userService.isEmailRegister(email);
		if(emailState == 0 || emailState == 1){
			
			User userChecked = userService.findUserByUserName(userName);
			if(userChecked != null && !userChecked.getEmail().equals(email)){ // 用户名已存在  且  用户名不与该email匹配就是被占用
				map.put("info", "用户名被占用，请修改用户名"); 
				return map;
			}
			
			String activationCode = EmailUtil.sendEmail(email); 
			
			User user= new User();
			user.setName(userName);
			user.setEmail(email);
			user.setPassword(password);
			user.setIsActive(Constants.NOT_ACTIVE);
			user.setActivationCode(activationCode);
			user.setPassword(PasswordUtil.geneMD5WithSalt(user.getPassword()));
			user.setRegisterTime(new Date());
			user.setLastLoginTime(new Date());
			user.setActivationCodeTime(DateTimeUtil.nowTime());
			if(emailState == 0){ // 注册用户
				int userId = userService.register(user);
				// 插入初始数据（item payMethod）
				initItem(userId);
				initPayMethod(userId);
			}else if(emailState == 1){ // 更新新注册用户
				int userId = userService.findUserByEmail(email).getId();
				user.setId(userId);
				userService.update(user);
			}
			
			session.setAttribute(Constants.EMAIL, email);
			map.put("info", "下一步");
			return map;
		}else if(emailState == 2){  // 已注册，请登录
			map.put("info", "邮箱已经注册，请登录");
			return map;
		}
		return map;
	}
	
	/**
	 * 注册第二步，激活邮箱，
	 */
	@RequestMapping(value = "/active.action", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String ,Object> active(User user){
		String result = userService.active(user.getEmail(), user.getActivationCode());
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("info", result);
		return map;
	}
	
	/**
	 * 登录
	 * @param session
	 * @param response
	 * @param account
	 * @param password
	 * @param checkCode
	 * @param rememberMe
	 * @return
	 */
	@RequestMapping(value = "/login.action", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String ,Object> login(HttpSession session, HttpServletResponse response, String account, String password,  String checkCode,String rememberMe) {
		final String REMEMBERME ="true";
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			String sessionCheckCode = String.valueOf(session.getAttribute(Constants.check_code_key));
			if(StringTools.isEmpty(sessionCheckCode)){
				map.put("info", "验证码已过期，请刷新页面重试");
				logger.info("验证码已过期，请刷新页面重试");
				return map;
			}
			if (!StringTools.isEmpty(sessionCheckCode) && !sessionCheckCode.equalsIgnoreCase(checkCode)) {
				map.put("info", "验证码错误");
				logger.info("验证码错误");
				return map;
			}
			
			User user = userService.login(account, password, false); 
			SessionUser sessionUser = new SessionUser();
			sessionUser.setUserId(user.getId());
			sessionUser.setUserName(user.getName());
			session.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
			session.setAttribute(Constants.USER_ID, user.getId());
			
			// 记住登录状态
			if (REMEMBERME.equals(rememberMe)) {
				// 自动登录，保存用户名密码到Cookie
				String infor = URLEncoder.encode(account.toString(), "utf-8") + "|" + user.getPassword();
				// 清除之前的Cookie信息
				Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				// 将用户信息保存到Cookie中
				Cookie cookieInfo = new Cookie(Constants.COOKIE_USER_INFO, infor);
				cookieInfo.setPath("/");
				// 设置最大生命周期为1年
				cookieInfo.setMaxAge(31536000);
				response.addCookie(cookieInfo);
			} else {  //清空cookie
				Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}catch(BusinessException e){
			if(map.get("info")==null){
				map.put("info", e.getMessage());
				logger.info("登录失败: "+ e.getMessage());
				return map;
			}
		}catch (Exception e) {
			if(map.get("info")==null){
				map.put("info", "登录失败");
				logger.info("登录失败");
			}
			return map;
		}
		map.put("info", "登录成功");
		return map;
	}
	
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout.action", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String ,Object> logout(HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//清空session
		session.setAttribute(Constants.SESSION_USER_KEY, null);
		//清空cookie
		Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		map.put("info", "注销成功");
		return map;
	}

	/**
	 * 生成图片验证码
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping(value = "checkCode.action")
	public void checkCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
		cs.setColorFactory(new SingleColorFactory(new Color(20, 60, 170)));
		cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		String code = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
		session.setAttribute(Constants.check_code_key, code);
	}
	
	/**
	 * 向item表中插入初始的item
	 * @param userId
	 */
	private void initItem(int userId) {
		itemService.addItem(userId, " ", "空项目", "in");
		itemService.addItem(userId, "工资", " ", "in");
		itemService.addItem(userId, "其他", " ", "in");
		itemService.addItem(userId, " ", "空项目", "ex");
		itemService.addItem(userId, "餐饮", " ", "ex");
		itemService.addItem(userId, "服饰", " ", "ex");
		itemService.addItem(userId, "医疗", " ", "ex");
		itemService.addItem(userId, "其他", " ", "ex");
	}
	
	/**
	 * 向pay_method表中插入初始的payMethod
	 * @param userId
	 */
	private void initPayMethod(int userId) {
		payMethodService.addPayMethod(userId, "余额宝", -1, "in", "");
		payMethodService.addPayMethod(userId, "现金", -1, "in", "");
		payMethodService.addPayMethod(userId, "微信", -1, "in", "");
		payMethodService.addPayMethod(userId, "银行卡", -1, "in", "");
		
		payMethodService.addPayMethod(userId, "余额宝", 1, "ex", "");
		payMethodService.addPayMethod(userId, "现金", 1, "ex", "");
		payMethodService.addPayMethod(userId, "微信", 1, "ex", "");
		payMethodService.addPayMethod(userId, "银行卡", 1, "ex", "");
		payMethodService.addPayMethod(userId, "花呗", 0, "ex", "");
		payMethodService.addPayMethod(userId, "信用卡", 0, "ex", "");
	}
	
	// ====================== Getter & Setter =========================
	public IPayMethodService getPayMethodService() {
		return payMethodService;
	}
	@Autowired
	public void setPayMethodService(IPayMethodService payMethodService) {
		this.payMethodService = payMethodService;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IItemService getItemService() {
		return itemService;
	}
	
	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
	
}


/**
 * 
 * .......................我佛慈悲......................
 *                       _oo0oo_
 *                      o8888888o
 *                      88" . "88
 *                      (| -_- |)
 *                      0\  =  /0
 *                    ___/`---'\___
 *                  .' \\|     |// '.
 *                 / \\|||  :  |||// \
 *                / _||||| -卍-|||||- \
 *               |   | \\\  -  /// |   |
 *               | \_|  ''\---/''  |_/ |
 *               \  .-\__  '-'  ___/-. /
 *             ___'. .'  /--.--\  `. .'___
 *          ."" '<  `.___\_<|>_/___.' >' "".
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /
 *     =====`-.____`.___ \_____/___.-`___.-'=====
 *                       `=---='
 *                       
 *.....................佛祖开光 ,永无BUG...................
 * 
 */

/**
 * 休闲一刻：
 * 请在"卍"中找"卐"
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卐卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 * 卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍卍
 **/