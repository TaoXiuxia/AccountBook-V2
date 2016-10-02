package com.taoxiuxia.service;

import java.util.List;

import com.taoxiuxia.model.Expenditure;

public interface IExpenditureService {
	
	/**
     * 加载全部支出
     * @return
     */
	List<Expenditure> loadExpenditures();
	
	/**
	 * 增加Expenditure
	 * @param item
	 * @param money
	 * @param remark
	 */
	void addExpenditure(int item,float money,String remark);
	
	/**
	 * 修改Expenditure
	 * @param ExpenditureId
	 * @param money
	 * @param itemId
	 * @param remark
	 */
	void changeExpenditure(int ExpenditureId,float money,int itemId ,String remark);
	
	/**
	 * 删除Expenditure
	 * @param ExpenditureId
	 * @param itemId
	 */
	void deleExpenditure(int ExpenditureId,int itemId);
}
