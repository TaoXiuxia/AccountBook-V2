package com.taoxiuxia.service;

import com.taoxiuxia.model.Balance;

public interface IMonthlyStatisticsService {

	/**
	 * 本月收入
	 * 
	 * @param userId
	 * @return
	 */
	float monthlyIncome(int userId);

	/**
	 * 本月支出
	 * 
	 * @param userId
	 * @return
	 */
	float monthlyExpenditure(int userId);
	
	/**
	 * 本月支出中花呗与信用卡的数额
	 * 
	 * @param userId
	 * @return
	 */
	float huaBeiAndCreditCard(int userId);

	/**
	 * 查询月初结余，即上月末结余
	 * 
	 * @param userId
	 * @return
	 */
	Balance balanceInBeginOfMonth(int userId);

	/**
	 * 本月结余，如果有就返回实际值，如果没有就返回null
	 * 
	 * @param userId
	 * @return
	 */
	Balance balanceOfThisMonth(int userId);

	/**
	 * 向数据库中插入本月实际的结余（由于种种原因，实际的结余总是与记录的数有出入，比如忘记记录） 每月只能插入一次，第一次插入，之后都是修改
	 * 
	 * @param balance
	 * @param userId
	 */
	void addBalance(float balance, int userId);

	/**
	 * 修改本月结余
	 * @param month
	 * @param changed_balance
	 * @param userId
	 */
	void changeBalance(int balanceId, float changed_balance);
}
