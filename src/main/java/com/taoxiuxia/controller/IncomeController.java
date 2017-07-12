package com.taoxiuxia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Balance;
import com.taoxiuxia.model.Expenditure;
import com.taoxiuxia.model.Income;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.service.IExpenditureService;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IMonthlyStatisticsService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.MyDateFormat;
import com.taoxiuxia.util.NumberFormat;

@Controller
@RequestMapping("/incomeController")
public class IncomeController {

	private IIncomeService incomeService;
	private IItemService itemService;
	private IMonthlyStatisticsService monthlyStatisticsService;
	
	public IIncomeService getIncomeService() {
		return incomeService;
	}

	@Autowired
	public void setIncomeService(IIncomeService incomeService) {
		this.incomeService = incomeService;
	}
	
	
	public IMonthlyStatisticsService getMonthlyStatisticsService() {
		return monthlyStatisticsService;
	}

	@Autowired
	public void setMonthlyStatisticsService(IMonthlyStatisticsService monthlyStatisticsService) {
		this.monthlyStatisticsService = monthlyStatisticsService;
	}
	
	public IItemService getItemService() {
		return itemService;
	}

	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * income页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showIncome")
	public String showIncomes(Model model, HttpSession session) {

		Map<String, Float> map = monthlyStatistics(session);

		//页面上的统计信息
		model.addAttribute("totalIncome", NumberFormat.save2Decimals(map.get("monthlyIncome")));
		model.addAttribute("totalExpenditure", NumberFormat.save2Decimals(map.get("monthlyExpenditure")));
		model.addAttribute("balanceInBeginOfMonth", NumberFormat.save2Decimals(map.get("balanceInBeginOfMonth")));
		model.addAttribute("balanceShould", NumberFormat.save2Decimals(map.get("balanceShould")));
		model.addAttribute("actualBalance", NumberFormat.save2Decimals(map.get("actualBalance")));
		
		// income list
		List<Income> incomes = incomeService.loadIncomes();
		model.addAttribute("incomes", incomes);
		
		// 收入项 list
		List<Item> items = itemService.loadIncomeItems(2); // 目前只有用户2
		model.addAttribute("items", items);

		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		model.addAttribute("sessionUser", sessionUser);

		return "pages/income";
	}

	/**
	 * 增加income
	 * 
	 * @param item
	 * @param money
	 * @param remark
	 */
	@RequestMapping("/addIncome")
	public void addIncomes(String date, int item, float money, String moneyType, String remark) {
		incomeService.addIncome(date, item, money, moneyType, remark);
	}

	/**
	 * 修改收入
	 * 
	 * @param incomeId
	 * @param money
	 * @param itemId
	 * @param remark
	 */
	@RequestMapping("/changeIncome")
	public void changeIncome(int incomeId, float money, String moneyType, int itemId, String remark, String date) {
		incomeService.changeIncome(incomeId, money, moneyType, itemId, remark, MyDateFormat.dateFormat(date));
	}

	/**
	 * 删除收入
	 * 
	 * @param incomeId
	 * @param itemId
	 */
	@RequestMapping("/deleIncome")
	public void deleIncome(int incomeId, int itemId) {
		incomeService.deleIncome(incomeId, itemId);
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
}
