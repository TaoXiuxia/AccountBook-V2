package com.taoxiuxia.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.ItemMapper;
import com.taoxiuxia.mapper.UserMapper;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.User;
import com.taoxiuxia.service.IUserService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.PasswordUtil;
import com.taoxiuxia.util.StringTools;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
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
		user.setPassword(PasswordUtil.geneMD5WithSalt(user.getPassword()));
		Date curDate = new Date();
		user.setRegisterTime(curDate);
		user.setLastLoginTime(curDate);
		int recordNum = userMapper.insert(user); //recordNum为受影响的记录数
		int userId = 0;
		if(recordNum == 1){
			userId = user.getId();
		}
		
		//向item表中插入初始的item
		addItem(userId, " ", "空项目", "in");
		addItem(userId, "工资", " ", "in");
		addItem(userId, "其他", " ", "in");
		addItem(userId, " ", "空项目", "ex");
		addItem(userId, "餐饮", " ", "ex");
		addItem(userId, "服饰", " ", "ex");
		addItem(userId, "医疗", " ", "ex");
		addItem(userId, "其他", " ", "ex");
		
		return 0;
	}

	@Override
	public User login(String account, String password,boolean hasMD5) {
		if (StringTools.isEmpty(account) || StringTools.isEmpty(password)) {
			logger.info("输入参数不合法,account或password不能为空");
			return null;
		}
		User user = null;
		if (account.contains("@")) { // 邮箱登录
			user = this.findUserByEmail(account);
		} else { // 用户名登录
			user = this.findUserByUserName(account);
		}
		if (null == user) {
			logger.info("用户不存在");
			return null;
		}
		if(hasMD5){
			if (!password.equals(user.getPassword())) {
				logger.info("密码错误  MD5");
				return null;
			}
		}else{
			if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
				logger.info("密码错误 not MD5");
				return null;
			}
		}
		return user;
	}
	
	public User findUserByEmail(String email) {
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("email", email);
		if(userMapper==null){
			userMapper = getUserMapper();
		}
		List<User>list = userMapper.findUserByEmail(map);
		System.out.println("findUserByEmail.size ==> "+list.size());
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	public User findUserByUserName(String userName) {
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("name", userName);
		if(userMapper == null){
			System.out.println("userMapper == null");
			userMapper = getUserMapper();
		}
		System.out.println("userMapper ==> "+userMapper);
		List<User>list = userMapper.findUserByUserName(map);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 更新用户，用的比较多，主要是更新最后登陆时间
	 * @param user
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * 添加item,复制了ItemServiceImpl中的addItem方法
	 */
	public void addItem(int userId, String itemName, String remark, String inOrEx) {
		Item item = new Item();
		item.setUserId(userId);
		item.setName(itemName);
		item.setInOrEx(inOrEx);
		item.setRemark(remark);
		item.setDele(Constants.NOT_DELE);
		itemMapper.insert(item);
		item.setSort(item.getId());
		itemMapper.updateByPrimaryKeySelective(item);
	}
}
