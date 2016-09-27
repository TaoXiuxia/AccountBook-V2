package com.taoxiuxia.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.util.NumberFormat;

@Controller
@RequestMapping("/incomeController")
public class IncomeController {

	private IIncomeService incomeService;

	public IIncomeService getIncomeService() {
		return incomeService;
	}
	
	@Autowired
	public void setIncomeService(IIncomeService incomeService) {
		this.incomeService = incomeService;
	}

	@RequestMapping("/showIncome")
	public String showIncomes(Model model) {
		
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
		return "pages/income";
	}
}
