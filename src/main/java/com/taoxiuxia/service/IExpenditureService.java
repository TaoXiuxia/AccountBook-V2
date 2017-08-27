package com.taoxiuxia.service;

import java.util.Date;
import java.util.List;

import com.taoxiuxia.model.Expenditure;

public interface IExpenditureService {
	
	/**
     * 加载全部支出
     * @return
     */
	List<Expenditure> loadExpenditures(int userId);
	
	/**
	 * 增加Expenditure
	 * @param item
	 * @param money
	 * @param remark
	 */
	void addExpenditure(int userId, String date, int item, float money, String moneyType, String remark);
	
	/**
	 * 修改Expenditure
	 * @param ExpenditureId
	 * @param money
	 * @param itemId
	 * @param remark
	 * @param date 
	 */
	void changeExpenditure(int ExpenditureId,float money, String moneyType, int itemId ,String remark, Date date);
	
	/**
	 * 删除Expenditure
	 * @param ExpenditureId
	 * @param itemId
	 */
	void deleExpenditure(int ExpenditureId);
}
