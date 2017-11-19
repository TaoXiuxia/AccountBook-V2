package com.taoxiuxia.service;

import java.util.List;
import java.util.Map;

public interface IHistoryService {
	
	/**
	 * 根据条件加载全部income和expenditure
	 * @param userId
	 * @param inOrEx
	 * @param year
	 * @param month
	 * @param keyword
	 * @return
	 */
	List<Map> loadIncomesAndExpenditure(int userId,String inOrEx,int year, int month, String keyword, String sortBy, int curPage, int totalPages);
	
	/**
	 * 根据条件查询全部income和expenditure的条数
	 * @param userId
	 * @param inOrEx
	 * @param year
	 * @param month
	 * @param keyword
	 * @return
	 */
	int countIncomesAndExpenditure(int userId,String inOrEx,int year, int month, String keyword);
	
	/**
	 * 查询过去12个月的每月收入
	 * @return
	 */
	List<Map> last12Income(int userId);
	
	/**
	 * 查询过去12个月的每月支出
	 * @return
	 */
	List<Map> last12Expenditure(int userId);
	
	/**
	 * 按照日期搜索income，并按照item name分组
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map> selectIncomeGroupByItemName(int userId, String startTime, String endTime);
	
	/**
	 * 按照日期搜索expenditure，并按照item name分组
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map> selectExpenditureGroupByItemName(int userId, String startTime, String endTime);
}
