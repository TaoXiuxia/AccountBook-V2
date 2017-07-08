package com.taoxiuxia.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Income;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.MyDateFormat;
import com.taoxiuxia.util.NumberFormat;

@Controller
@RequestMapping("/incomeController")
public class IncomeController {

	private IIncomeService incomeService;
	private IItemService itemService;

	public IIncomeService getIncomeService() {
		return incomeService;
	}
	
	@Autowired
	public void setIncomeService(IIncomeService incomeService) {
		this.incomeService = incomeService;
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
	 * @param model
	 * @return
	 */
	@RequestMapping("/showIncome")
	public String showIncomes(Model model,HttpSession session) {
		
		// 收入income
		List<Income> incomes = incomeService.loadIncomes();
				
		float totalIncome = 0;
		float averageIncome = 0;
		for(Income income:incomes){
			totalIncome +=income.getMoney();
		} 
		Calendar ca = Calendar.getInstance();
		averageIncome = NumberFormat.to2Decimals(totalIncome/ca.get(Calendar.DAY_OF_MONTH)*100);
		model.addAttribute("incomes", incomes);
		model.addAttribute("totalIncome", totalIncome);
		model.addAttribute("averageIncome", averageIncome);
		
		// 收入列表项
		List<Item>items = itemService.loadIncomeItems(2);  // 目前只有用户2
		model.addAttribute("items", items);	

		SessionUser sessionUser= (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		model.addAttribute("sessionUser", sessionUser);
		
		return "pages/income";
	}
	
	/**
	 * 增加income
	 * @param item
	 * @param money
	 * @param remark
	 */
	@RequestMapping("/addIncome")
	public void addIncomes(int item,float money,String remark) {
		incomeService.addIncome(item, money, remark);
	}
	
	/**
	 * 修改收入
	 * @param incomeId
	 * @param money
	 * @param itemId
	 * @param remark
	 */
	@RequestMapping("/changeIncome")
	public void changeIncome(int incomeId,float money,int itemId ,String remark, String date) {
		incomeService.changeIncome(incomeId, money, itemId, remark,MyDateFormat.dateFormat(date));
	}
	
	/**
	 * 删除收入
	 * @param incomeId
	 * @param itemId
	 */
	@RequestMapping("/deleIncome")
	public void deleIncome(int incomeId,int itemId) {
		incomeService.deleIncome(incomeId,itemId);
	}
}
