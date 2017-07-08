package com.taoxiuxia.util;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

public class PasswordUtil {


	/**
	 * 生成含有随机盐的密码
	 */
	public static String geneMD5WithSalt(String password) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder(16); // 生成一个16位的salt
		sb.append(r.nextInt(99999999)).append(r.nextInt(99999999)); // 随机数，即使密码是一样的，生成的密文也是不一样的
		int len = sb.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				sb.append("0");
			}
		}
		String salt = sb.toString();  // 生成的salt
		password = md5Hex(password + salt); // 32位
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) { // 32位的md5密文与16位的salt混合，生成48位的密码
			cs[i] = password.charAt(i / 3 * 2);
			cs[i + 1] = salt.charAt(i / 3);
			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
		}
		return new String(cs);
	}

	/**
	 * 校验密码是否正确
	 * 
	 * @param password 是被校验的密码（）
	 * @param md5 数据库中存储的密码（密文）
	 * @return
	 */
	public static boolean verifyPassword(String password, String md5) {
		char[] cs1 = new char[32];
		char[] cs2 = new char[16];
		for (int i = 0; i < 48; i += 3) { // 将md5密文与salt分离
			cs1[i / 3 * 2] = md5.charAt(i);
			cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
			cs2[i / 3] = md5.charAt(i + 1);
		}
		String salt = new String(cs2);
		return md5Hex(password + salt).equals(new String(cs1));
	}

	/**
	 * 获取十六进制字符串形式的MD5摘要
	 */
	public static String md5Hex(String src) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest(src.getBytes());
			return new String(new Hex().encode(bs));
		} catch (Exception e) {
			return null;
		}
	}
}