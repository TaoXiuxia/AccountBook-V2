package com.taoxiuxia.util;

public class Constants {

	public static final int LENGTH_20 = 20;
	public static final int LENGTH_6 = 6;
	public static final int LENGTH_16 = 16;

	public static final String user_img_path_user_icon = "defusericon/usericon";
	public static final String user_img_path_user_bg = "defbg/bg";

	/**
	 * 验证码
	 */
	public static final String check_code_key = "check_code";

	public static final String SESSION_USER_KEY = "session_user_key";
	
	public static final String USER_ID = "useId";
	
	public static final String EMAIL = "email";

	public static final String SESSION_ERROR_LOGIN_COUNT="session_error_login_count";
	
	public static final int MAX_LOGIN_ERROR_COUNT = 3; 
	
	public static final int CONTINUESIGNINCOUNT = 7;
	
	public static final String COOKIE_USER_INFO = "cookie4UserInfo";
	
	public static final String ABSOLUTEPATH = "absolutePath";
	
	/**
	 * 每页显示的记录数
	 */
	public static final int RECORD_NUM_PER_PAGE = 20;
	
	/**
	 * 没有被删除
	 */
	public static final int NOT_DELE = 1;
	
	/**
	 * 被删除
	 */
	public static final int DELE = -1;
	
	/**
	 * 只查询本月的数据
	 */
	public static final String ONLY_THIS_MONTH = "only_this_month";
	
	/**
	 * 查询全部的数据，而不只是本月的
	 */
	public static final String NOT_ONLY_THIS_MONTH = "not_only_this_month";
	
	/**
	 * 已经激活
	 */
	public static final Integer ACTIVE = 1;
	
	/**
	 * 未激活
	 */
	public static final Integer NOT_ACTIVE = 0;
	
}
