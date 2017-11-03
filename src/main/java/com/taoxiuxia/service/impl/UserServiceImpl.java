package com.taoxiuxia.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.exception.BusinessException;
import com.taoxiuxia.mapper.ItemMapper;
import com.taoxiuxia.mapper.UserMapper;
import com.taoxiuxia.model.User;
import com.taoxiuxia.service.IUserService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.DateTimeUtil;
import com.taoxiuxia.util.PasswordUtil;
import com.taoxiuxia.util.StringTools;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Resource
	private ItemMapper itemMapper;

	public ItemMapper getItemMapper() {
		return itemMapper;
	}

	@Autowired
	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	/**
	 * 注册用户
	 */
	@Override
	public int register(User user) {
		//向user表中插入数据
		int recordNum = userMapper.insert(user); //recordNum为受影响的记录数
		int userId = 0;
		if(recordNum == 1){
			userId = user.getId();
		}
		return userId;
	}

	@Override
	public User login(String account, String password, boolean hasMD5) throws Exception{
		if (StringTools.isEmpty(account) || StringTools.isEmpty(password)) {
			throw new BusinessException("输入参数不合法,account或password不能为空");
		}
		User user = null;
		if (account.contains("@")) { // 邮箱登录
			user = this.findUserByEmail(account);
		} else { // 用户名登录
			user = this.findUserByUserName(account);
		}
		if (null == user) {
			throw new BusinessException("用户不存在，请前往注册");
		}
		if(hasMD5){
			if (!password.equals(user.getPassword())) {
				throw new BusinessException("密码错误");  //MD5
			}
		}else{
			if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
				throw new BusinessException("密码错误"); // not MD5
			}
		}
		if(user.getIsActive() == 0){
			throw new BusinessException("该邮箱尚未激活，请重新注册并激活");
		}
		
		user.setLastLoginTime(new Date());
		userMapper.updateByPrimaryKeySelective(user);
		return user;
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Override
	public int isEmailRegister(String email){
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("email", email);
		List<User> userlist = userMapper.findUserByEmail(map);
		if(userlist.size()==0){
			return 0;
		}
		User user = userlist.get(0);
		if(user.getIsActive()==1){
			return 2; 
		}else{
			return 1;
		}
	}
	
	@Override
	public String active(String email, String activationCode) {
		User user = findUserByEmail(email);
		if(StringTools.isEmpty(activationCode)){
			return "激活码为空";
		}
		
		if(DateTimeUtil.compareTimeByMin(user.getActivationCodeTime(), DateTimeUtil.nowTime())>180){
			return "激活码失效，请重新注册";
		}
		
		int row; // 受影响的行
		if(activationCode.equals(user.getActivationCode())){
			user.setIsActive(Constants.ACTIVE);
			row = userMapper.updateByPrimaryKeySelective(user);
			if(row == 1){
				return "激活成功";
			}
		}
 		return "激活失败";
	}
	
	@Override
	public User findUserByEmail(String email) {
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("email", email);
		List<User>list = userMapper.findUserByEmail(map);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findUserByUserName(String userName) {
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("name", userName);
		if(userMapper == null){
			userMapper = getUserMapper();
		}
		List<User>list = userMapper.findUserByUserName(map);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}

	
}
