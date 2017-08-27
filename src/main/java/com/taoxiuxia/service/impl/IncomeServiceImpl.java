package com.taoxiuxia.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.IncomeMapper;
import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.util.Constants;
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

	/**
	 * 加载用户的本月的收入
	 */
	@Override
	public List<Income> loadIncomes(int userId) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("dataScale", Constants.ONLY_THIS_MONTH);
		return incomeMapper.selectAllIncomes(map);
	}

	/**
	 * 添加收入income
	 */
	@Override
	public void addIncome(int userId, String date, int item, float money, String moneyType, String remark) {
		Income income = new Income();
		income.setItemId(item);
		income.setUserId(userId); 
		income.setDele(Constants.NOT_DELE);
		income.setMoney(money);
		income.setType_of_money(moneyType);
		income.setDate(MyDateFormat.dateFormat(date));
		income.setRemark(remark);
		incomeMapper.insert(income);
	}
	
	/**
	 * 修改income
	 */
	@Override
	public void changeIncome(int incomeId, float money, String moneyType, int itemId, String remark, Date date) {
		Income income = new Income();
		income.setId(incomeId);
		income.setItemId(itemId);
		income.setMoney(money);
		income.setType_of_money(moneyType);
		income.setRemark(remark);
		income.setDate(date);
		incomeMapper.updateByPrimaryKeySelective(income);
	}

	/**
	 * 删除income，只需要incomeId定位，其他的字段都不需要
	 */
	@Override
	public void deleIncome(int incomeId) {
		Income income = new Income();
		income.setId(incomeId);
		income.setDele(Constants.DELE); 
		incomeMapper.updateByPrimaryKeySelective(income);
	}
}
