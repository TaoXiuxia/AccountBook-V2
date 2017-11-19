package com.taoxiuxia.util;

public class NumberFormat {

	public static float to2Decimals(float num){
		return (float)(int)(num)/100;
	}

	/**
	 * 保留2位小数
	 * @param num
	 * @return
	 */
	public static float save2Decimals(float num){ 
		return (float)(int)(num*100)/100;
	}
	
	public static double save2Decimals(double num){ 
		return (double)(int)(num*100)/100;
	}
	
}
