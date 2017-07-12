package com.taoxiuxia.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.IncomeMapper;
import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.util.MyDateFormat;

@Service("incomeService")
public class IncomeServiceImpl implements IIncomeService {

	private IncomeMapper incomeMapper;

	public IncomeMapper getIncomeMapper() {
		return incomeMapper;
	}

	@Autowired
	public void setIncomeMapper(IncomeMapper incomeMapper) {
		this.incomeMapper = incomeMapper;
	}

	@Override
	public List<Income> loadIncomes() {
		return incomeMapper.selectAllIncomes();
	}

	@Override
	public void addIncome(String date, int item, float money, String moneyType, String remark) {
		Income income = new Income();
		income.setItemId(item);
		income.setUserId(2); 
		income.setDele(0);
		income.setMoney(money);
		income.setType_of_money(moneyType);
		income.setDate(MyDateFormat.dateFormat(date));
		income.setRemark(remark);
		incomeMapper.insert(income);
	}

	@Override
	public void changeIncome(int incomeId, float money, String moneyType, int itemId, String remark, Date date) {
		Income income = new Income();
		income.setDate(null);
		income.setDele(0);
		income.setUserId(2); // 如果不设置会自动设置成0，为什么？？
		income.setId(incomeId);
		income.setItemId(itemId);
		income.setMoney(money);
		income.setType_of_money(moneyType);
		income.setRemark(remark);
		income.setDate(date);
		incomeMapper.updateByPrimaryKeySelective(income);
	}

	@Override
	public void deleIncome(int incomeId,int itemId) {
		Income income = new Income();
		income.setId(incomeId);
		income.setDele(1);
		income.setDate(null);
		income.setUserId(2); // 如果不设置会自动设置成0，为什么？？
		income.setItemId(itemId);  // 正常应该这里不设置，但是因为会自动设置成0，所以从前台传itemid进来
		income.setMoney(null);
		income.setType_of_money(null);
		income.setRemark(null);
		incomeMapper.updateByPrimaryKeySelective(income);
	}
}
