package com.taoxiuxia.service;

import java.util.List;

import com.taoxiuxia.model.PayMethod;

public interface IPayMethodService {

	/**
	 * 加载全部pay method
	 * @return
	 */
	List<PayMethod> loadPayMethods(int id, String inOrEx);
	
	/**
	 * 增加pay method，income or expenditure
	 * @param inOrEx
	 */
	void addPayMethod(int userId, String payMethodName,int isCountInThisMonthEx,String inOrEx, String remark);
	
	/**
	 * 修改pay method只需要id定位到pay method就可以了，不需要userId inOrEx sort字段
	 */
	void changePayMethod(int payMethodId, String payMethodName, int isCountInThisMonthEx, String remark);
	
	/**
	 * 删除pay method 只需id定位到pay method就可以了，其他的字段都不需要
	 */
	void delePayMethod(int payMethodId);
	
	/**
	 * 上移下移pay method
	 * @param userId
	 * @param payMethodId
	 * @param inOrEx
	 * @param upAndDown
	 * @return
	 */
	String upAndDownPayMethod(int userId, int payMethodId,  String inOrEx, String upAndDown);
}
