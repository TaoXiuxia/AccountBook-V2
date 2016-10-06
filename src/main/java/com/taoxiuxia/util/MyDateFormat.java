package com.taoxiuxia.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat {
	
	/**
	 * 处理日期，将只有年月日的日期字符串转化成日期格式的Date
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date dateFormat(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
