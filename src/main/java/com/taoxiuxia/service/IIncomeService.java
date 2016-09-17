package com.taoxiuxia.service;

import java.util.List;

import com.taoxiuxia.model.Income;

public interface IIncomeService {
	
	/**
     * 加载全部income
     * @return
     */
	List<Income> loadIncomes();
}
