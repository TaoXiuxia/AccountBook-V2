package com.taoxiuxia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeUtil {

	
	/**
	 *  YYYY-MM-dd hh:mm:ss格式返回现在时间
	 */
	public static String nowTime() {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  // HH24小时制，hh12小时制
		Date date = new Date();
		return bartDateFormat.format(date);
	}
	
	public static int compareTimeByMin(String time1, String time2){
		int hours = 0;
		try {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			long from = simpleFormat.parse(time1).getTime();
			long to = simpleFormat.parse(time2).getTime();  
			hours = Math.abs((int) ((to - from)/(1000 * 60)));  
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return hours;
	}
	
	/**
	 * 本月第一天
	 * @return
	 */
	public static String firstDayOfThisMonth(){
		LocalDate today = LocalDate.now();
        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        return firstday + "";	// 默认格式YYYY-MM-dd
	}
	
	/**
	 * 本月最后一天
	 * @return
	 */
	public static String lastDayOfThisMonth(){
		LocalDate today = LocalDate.now();
        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay + "";
	}
}
