package com.taoxiuxia.util;

public class NumberFormat {

	public static float to2Decimals(float num){
		return (float)(int)(num)/100;
	}

	public static float save2Decimals(float num){ //保留2位小数
		return (float)(int)(num*100)/100;
	}
	
}
