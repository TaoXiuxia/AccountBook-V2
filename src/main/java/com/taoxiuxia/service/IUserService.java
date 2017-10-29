package com.taoxiuxia.service;

import com.taoxiuxia.model.User;

public interface IUserService {

	/**
	 * 用户注册
	 * @param user
	 */
	public int register(User user);
	
	/**
	 * @param account 帐号可以是用户名或者邮箱
	 * @param password
	 * @return User
	 * @throws BusinessException
	 */
	public User login(String account, String password, boolean hasMD5);
	
	/**
	 * 更新用户，用的比较多，主要是更新最后登陆时间
	 * @param user
	 */
	public void update(User user);

	/**
	 * 根据邮箱判断用户是否已经注册
	 * @param email
	 * @return 	0:未注册
	 * 			1:已注册，未激活
	 * 			2:已注册，已激活
	 */
	public int isEmailRegister(String email);

	/**
	 * 激活用户邮箱
	 * @param user
	 * @return
	 */
	public String active(String email, String activationCode);
}
