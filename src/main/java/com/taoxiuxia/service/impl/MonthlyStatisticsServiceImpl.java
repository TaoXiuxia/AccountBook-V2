package com.taoxiuxia.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.BalanceMapper;
import com.taoxiuxia.model.Balance;
import com.taoxiuxia.service.IMonthlyStatisticsService;

@Service("monthlyStatisticsService")
public class MonthlyStatisticsServiceImpl implements IMonthlyStatisticsService {

	private BalanceMapper balanceMapper;

	public BalanceMapper getBalanceMapper() {
		return balanceMapper;
	}

	@Autowired
	public void setBalanceMapper(BalanceMapper balanceMapper) {
		this.balanceMapper = balanceMapper;
	}

	@Override
	public float monthlyIncome(int userId) {
		return balanceMapper.selectMonthlyIncome(userId);
	}

	@Override
	public float monthlyExpenditure(int userId) {
		return balanceMapper.selectMonthlyExpenditure(userId);
	}

	@Override
	public float balanceInBeginOfMonth(int userId) {
		return balanceMapper.selectBalanceInBeginOfMonth(userId);
	}

	@Override
	public Balance balanceOfThisMonth(int userId) {
		return balanceMapper.selectBalanceOfThisMonth(userId);
	}

	@Override
	public void addBalance(float balanceMoney, int userId) {
		Balance balance = new Balance();
		balance.setUserId(userId);
		balance.setActualBalance(balanceMoney);
		balance.setMonth(new Date());
		balanceMapper.insertBalance(balance);
	}

	@Override
	public void changeBalance(int balanceId,float balanceMoney, int userId) {
		Balance balance = new Balance();
		balance.setId(balanceId);
		balance.setActualBalance(balanceMoney);
		balanceMapper.updateByPrimaryKeySelective(balance);
	}

}
