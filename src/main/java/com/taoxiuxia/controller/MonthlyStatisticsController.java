package com.taoxiuxia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Balance;
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

	public Map<String,Float> monthlyStatistics(HttpSession session) {
		Map<String,Float>map = new HashMap<String, Float>();
		
		// 月收入
		float monthlyIncome = monthlyStatisticsService.monthlyIncome(2); 
		map.put("monthlyIncome", monthlyIncome);
		
		// 月支出
		float monthlyExpenditure = monthlyStatisticsService.monthlyExpenditure(2);  
		map.put("monthlyExpenditure", monthlyExpenditure);
		
		// 本月初（上月末）结余
		float balanceInBeginOfMonth = monthlyStatisticsService.balanceInBeginOfMonth(2);
		map.put("balanceInBeginOfMonth", balanceInBeginOfMonth);
		
		// 本月应结余 ==> 月初结余+月收入-月支出
		float balanceShould = balanceInBeginOfMonth + monthlyIncome - monthlyExpenditure;
		map.put("balanceShould", balanceShould);
		
		// 本月实际结余
		Balance balanceOfThisMonth = monthlyStatisticsService.balanceOfThisMonth(2);
		float actualBalance; // 本月实际结余
		if(balanceOfThisMonth == null){
			actualBalance = -1;
		}else{
			actualBalance = balanceOfThisMonth.getActualBalance();
		}
		map.put("actualBalance", actualBalance);
		
		return map;
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
//		monthlyStatisticsService.changeBalance(balanceId,actualBalance, 2);

		
	}
}
