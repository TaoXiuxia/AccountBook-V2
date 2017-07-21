package com.taoxiuxia.service;

import java.util.List;
import java.util.Map;

import com.taoxiuxia.model.Income;

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
}
