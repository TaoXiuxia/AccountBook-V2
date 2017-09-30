package com.taoxiuxia.util;

public class StringTools {
/*
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
*/
	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str)||"null".equals(str)) {
			return true;
		} else if ("".equals(str.trim())) {
			return true;
		}
		return false;
	} 
	

	/**
	 * 校验是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String checkPassword = "^[0-9]+$";
		if (null == str) {
			return false;
		}
		if (!str.matches(checkPassword)) {
			return false;
		}
		return true;
	}

	/**
	 * 校验邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		String checkEamil = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
		if (!isEmpty(email)) {
			return email.matches(checkEamil);
		} else {
			return false;
		}
	}

	/**
	 * 校验用户名格式
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean checkUsername(String userName) {
		String checkUsername = "^[\\w\\u4e00-\\u9fa5]+$";
		if (!isEmpty(userName)) {
			return userName.matches(checkUsername);
		} else {
			return false;
		}
	}

	/**
	 * 校验密码格式
	 * 
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {
		String checkPassword = "^[0-9a-zA-Z]+$";
		if (!isEmpty(password)) {
			return password.matches(checkPassword);
		} else {
			return false;
		}
	}
}
