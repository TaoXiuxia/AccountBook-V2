package com.taoxiuxia.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Balance;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IMonthlyStatisticsService;
import com.taoxiuxia.util.NumberFormat;

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
	 * MonthlyStatistics页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showMonthlyStatistics")
	public String showMonthlyStatistics(Model model) {

		Calendar ca = Calendar.getInstance();
		
		int now = ca.get(Calendar.DAY_OF_MONTH);
		int lastDay = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
		String isLastDay = (now==lastDay)+"";
		
		float monthlyIncome = monthlyStatisticsService.monthlyIncome(2);
		float averageIncome = NumberFormat.to2Decimals(monthlyIncome/now*100);
		float monthlyExpenditure = monthlyStatisticsService.monthlyExpenditure(2);
		float averageExpenditure = NumberFormat.to2Decimals(monthlyExpenditure/now*100);
		float balanceInBeginOfMonth = monthlyStatisticsService.balanceInBeginOfMonth(2);
		Balance balanceOfThisMonth = monthlyStatisticsService.balanceOfThisMonth(2);
		float balanceShould = balanceInBeginOfMonth + monthlyIncome - monthlyExpenditure;
		
		model.addAttribute("isLastDay", isLastDay);
		model.addAttribute("monthlyIncome", monthlyIncome);
		model.addAttribute("averageIncome", averageIncome);
		model.addAttribute("monthlyExpenditure", monthlyExpenditure);
		model.addAttribute("averageExpenditure", averageExpenditure);
		model.addAttribute("balanceInBeginOfMonth", balanceInBeginOfMonth);
		model.addAttribute("balanceOfThisMonth", balanceOfThisMonth);
		model.addAttribute("balanceShould", balanceShould);
		
		return "pages/monthlyStatistics";
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
	 * 修改item
	 * 
	 * @param itemId
	 * @param itemName
	 * @param remark
	 * @param inOrEx
	 */
	@RequestMapping("/changeBalance")
	public void changeBalance(int balanceId,float actualBalance) {
		monthlyStatisticsService.changeBalance(balanceId,actualBalance, 2);
	}
}
