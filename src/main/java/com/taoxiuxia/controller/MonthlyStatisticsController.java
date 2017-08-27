package com.taoxiuxia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.service.IMonthlyStatisticsService;
import com.taoxiuxia.util.Constants;

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
	 * 增加Balance
	 * 
	 */
	@RequestMapping("/addBalance")
	public void addBalance(float actualBalance, HttpSession session) {
		int userId = (int)session.getAttribute(Constants.USER_ID);
		monthlyStatisticsService.addBalance(actualBalance, userId);
	}

	/**
	 * 修改balance
	 * @param balanceId
	 * @param actualBalance
	 */
	@RequestMapping("/changeBalance")
	public void changeBalance(int balanceId,float changed_balance) {
		monthlyStatisticsService.changeBalance(balanceId, changed_balance);
	}
}
