package com.taoxiuxia.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringContextUtil {

	private static ApplicationContext context = null;

	public static void setContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.context = applicationContext;
	}

	public static Object getBean(String name) {
		return context.getBean(name);
	}
}
