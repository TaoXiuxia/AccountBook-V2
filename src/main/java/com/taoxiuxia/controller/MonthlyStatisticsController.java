package com.taoxiuxia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.service.IMonthlyStatisticsService;

@Controller
@RequestMapping("/monthlyStatisticsController")
public class MonthlyStatisticsController {
	private IMonthlyStatisticsService monthlyStatisticsService;

	public IMonthlyStatisticsService getMonthlyStatisticsService() {
		return monthlyStatisticsService;
	}

	@Autowired
	public void setMonthlyStatisticsService(IMonthlyStatisticsService monthlyStatisticsService) {
		this.monthlyStatisticsService = monthlyStatisticsService;
	}

	/**
	 * 增加item
	 * 
	 * @param itemName
	 * @param remark
	 */
	@RequestMapping("/addBalance")
	public void addBalance(float actualBalance) {
		monthlyStatisticsService.addBalance(actualBalance, 2);
	}

	/**
	 * 
	 * @param balanceId
	 * @param actualBalance
	 */
	@RequestMapping("/changeBalance")
	public void changeBalance(String month, float changed_balance) {
		monthlyStatisticsService.changeBalance(month,changed_balance, 2);
	}
}
