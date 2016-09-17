package com.taoxiuxia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IIncomeService;

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
		List<Income> incomes = incomeService.loadIncomes();
		model.addAttribute("incomes", incomes);
		return "showIncome";
	}
}
