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
import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.PayMethod;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.service.IExpenditureService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IMonthlyStatisticsService;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.MyDateFormat;
import com.taoxiuxia.util.NumberFormat;

@Controller
@RequestMapping("/expenditureController")
public class ExpenditureController {

	private IExpenditureService expenditureService;
	private IItemService itemService;
	private IMonthlyStatisticsService monthlyStatisticsService;
	private IPayMethodService payMethodService;

	public IExpenditureService getExpenditureService() {
		return expenditureService;
	}
	@Autowired
	public void setExpenditureService(IExpenditureService expenditureService) {
		this.expenditureService = expenditureService;
	}

	public IItemService getItemService() {
		return itemService;
	}
	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public IMonthlyStatisticsService getMonthlyStatisticsService() {
		return monthlyStatisticsService;
	}
	@Autowired
	public void setMonthlyStatisticsService(IMonthlyStatisticsService monthlyStatisticsService) {
		this.monthlyStatisticsService = monthlyStatisticsService;
	}
	
	public IPayMethodService getPayMethodService() {
		return payMethodService;
	}
	@Autowired
	public void setPayMethodService(IPayMethodService payMethodService) {
		this.payMethodService = payMethodService;
	}

	/**
	 * expenditure页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showExpenditure")
	public String showExpenditures(Model model,HttpSession session) {
		Map<String, Float> map = monthlyStatistics(session);

		//页面上的统计信息
		model.addAttribute("totalIncome", NumberFormat.save2Decimals(map.get("monthlyIncome")));
		model.addAttribute("totalExpenditure", NumberFormat.save2Decimals(map.get("monthlyExpenditure")));
		model.addAttribute("notActualExpenditure", NumberFormat.save2Decimals(map.get("notActualExpenditure")));
		model.addAttribute("balanceInBeginOfMonth", NumberFormat.save2Decimals(map.get("balanceInBeginOfMonth")));
		model.addAttribute("balanceId_InBeginOfMonth", NumberFormat.save2Decimals(map.get("balanceId_InBeginOfMonth")));
		model.addAttribute("balanceShould", NumberFormat.save2Decimals(map.get("balanceShould")));
		model.addAttribute("actualBalance", NumberFormat.save2Decimals(map.get("actualBalance")));
		model.addAttribute("actualBalanceId", NumberFormat.save2Decimals(map.get("actualBalanceId")));
		model.addAttribute("actualExpenditure", NumberFormat.save2Decimals(map.get("actualExpenditure")));
		
		SessionUser sessionUser= (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		model.addAttribute("sessionUser", sessionUser);
		int userId = sessionUser.getUserId();
		
		// Expenditure list
		List<Expenditure> expenditures = expenditureService.loadExpenditures(userId);
		model.addAttribute("expenditures", expenditures);

		// Expenditure项 list 
		List<Item> items = itemService.loadExpenditureItems(userId);
		model.addAttribute("items", items);
		
		//收入方式list
		List<PayMethod> payMethods = payMethodService.loadPayMethods(userId, "ex");
		model.addAttribute("payMethods", payMethods);
				
		return "pages/expenditure";
	}

	/**
	 * 增加Expenditures
	 * 
	 * @param item
	 * @param money
	 * @param remark
	 */
	@RequestMapping("/addExpenditure")
	public void addExpenditures(String date, int item, float money, String moneyType, String remark, HttpSession session) {
		int userId = (int)session.getAttribute(Constants.USER_ID);
		expenditureService.addExpenditure(userId, date, item, money, moneyType, remark);
	}

	/**
	 * 修改Expenditures
	 * 
	 * @param ExpendituresId
	 * @param money
	 * @param itemId
	 * @param remark
	 */
	@RequestMapping("/changeExpenditure")
	public void changeExpenditures(int expenditureId, float money, String moneyType, int itemId, String remark,String date, HttpSession session) {
		expenditureService.changeExpenditure(expenditureId, money, moneyType, itemId, remark,MyDateFormat.dateFormat(date));
	}

	/**
	 * 删除Expenditures
	 * 
	 * @param ExpenditureId
	 * @param itemId
	 */
	@RequestMapping("/deleExpenditure")
	public void deleExpenditure(int expenditureId) {
		expenditureService.deleExpenditure(expenditureId);
	}
	
	/**
	 * 在收入和支出页面上 统计部分的内容 
	 * 这部分和ExpenditureController的相同方法完全一样
	 * 
	 * @param session
	 * @return
	 */
	public Map<String,Float> monthlyStatistics(HttpSession session) {
		int userId = (int) session.getAttribute(Constants.USER_ID);
		Map<String,Float>map = new HashMap<String, Float>();
		
		// 月收入
		float monthlyIncome = monthlyStatisticsService.monthlyIncome(userId); 
		map.put("monthlyIncome", monthlyIncome);
		
		// 月支出
		float monthlyExpenditure = monthlyStatisticsService.monthlyExpenditure(userId);  
		map.put("monthlyExpenditure", monthlyExpenditure);
		
		// 月支出中花呗与信用卡的数额
		float notActualExpenditure = monthlyStatisticsService.notActualExpenditure(userId);
		map.put("notActualExpenditure", notActualExpenditure);
		
		// 本月实际支出 
		float actualExpenditure = monthlyExpenditure - notActualExpenditure;
		map.put("actualExpenditure", actualExpenditure);
		
		// 本月初（上月末）结余
		Balance balance_InBeginOfMonth = monthlyStatisticsService.balanceInBeginOfMonth(userId);
		float actualBalance_InBeginOfMonth = balance_InBeginOfMonth.getActualBalance();
		map.put("balanceInBeginOfMonth", actualBalance_InBeginOfMonth);
		map.put("balanceId_InBeginOfMonth", balance_InBeginOfMonth.getId() + 0f); 
		
		// 本月应结余 ==> 月初结余+月收入- (月支出-花呗/信用卡)
		float balanceShould = actualBalance_InBeginOfMonth + monthlyIncome - (monthlyExpenditure - notActualExpenditure);
		map.put("balanceShould", balanceShould);
		
		// 本月实际结余
		Balance balanceOfThisMonth = monthlyStatisticsService.balanceOfThisMonth(userId);
		float actualBalance; // 本月实际结余
		float actualBalanceId;
		if(balanceOfThisMonth == null){
			actualBalance = -1;
			actualBalanceId = -1;
		}else{
			actualBalance = balanceOfThisMonth.getActualBalance();
			actualBalanceId = balanceOfThisMonth.getId();
		}
		map.put("actualBalance", actualBalance);
		map.put("actualBalanceId", actualBalanceId);
		
		return map;
	}
}
