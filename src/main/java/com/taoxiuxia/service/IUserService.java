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
	 * @return TODO
	 * @throws BusinessException
	 */
	public User login(String account, String password, boolean hasMD5);
	
	/**
	 * 更新用户，用的比较多，主要是更新最后登陆时间
	 * @param user
	 */
	public void update(User user);

}
