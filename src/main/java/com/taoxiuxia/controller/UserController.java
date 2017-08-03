package com.taoxiuxia.controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.model.User;
import com.taoxiuxia.service.IUserService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.StringTools;

import checkcode.patchca.color.SingleColorFactory;
import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.service.ConfigurableCaptchaService;
import checkcode.patchca.utils.encoder.EncoderHelper;

@Controller
@RequestMapping("/userController")
public class UserController {

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/showUserRegister.action")
	public String showUserRegister(Model model) {
		return "pages/userRegister";
	}
	
	@RequestMapping("/showUserLogin.action")
	public String showUserLogin(Model model) {
		return "pages/userLogin";
	}

	/**
	 * 注册
	 * @param session
	 * @param userName
	 * @param email
	 * @param password
	 * @param checkCode
	 * @return
	 */
	@RequestMapping(value = "/register.action", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String ,Object> register(HttpSession session, String userName, String email, String password,
			String checkCode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sessionCheckCode = session.getAttribute(Constants.check_code_key).toString();
		
		if (!sessionCheckCode.equalsIgnoreCase(checkCode)) {
			map.put("info", "验证码错误");
		} else {
			User user= new User();
			user.setName(userName);
			user.setEmail(email);
			user.setPassword(password);
			userService.register(user);
			
			SessionUser sessionUser = new SessionUser();
			sessionUser.setUserId(user.getId());
			sessionUser.setUserName(user.getName());
			session.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
			map.put("info", "注册成功");
		}
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
			if (!StringTools.isEmpty(sessionCheckCode) && !sessionCheckCode.equalsIgnoreCase(checkCode)) {
				map.put("info", "验证码错误");
				return map;
			}
			
			User user = userService.login(account, password, false); 
			SessionUser sessionUser = new SessionUser();
			sessionUser.setUserId(user.getId());
			sessionUser.setUserName(user.getName());
			session.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
			
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
			} else {
				Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			map.put("info", "登录失败");
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
	public @ResponseBody Map<String ,Object> logout(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		session.setAttribute(Constants.SESSION_USER_KEY, null);
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

}
