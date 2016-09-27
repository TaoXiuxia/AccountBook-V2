package com.taoxiuxia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.IncomeMapper;
import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IIncomeService;

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
}
