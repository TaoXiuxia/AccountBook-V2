package com.taoxiuxia.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
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
	public float notActualExpenditure(int userId) {
		return balanceMapper.selectHuaBeiAndCreditCard(userId);
	}
	
	/**
	 * 本月初的实际结余balance，也就是上月末的实际balance
	 */
	@Override
	public Balance balanceInBeginOfMonth(int userId) {
		//如果查出来的是null，说明上月没有balance数据
		//就插入一条actual_balance为0的数据
		if(balanceMapper.selectBalanceInBeginOfMonth(userId) == null){
			Balance balance = new Balance();
			balance.setUserId(userId);
			balance.setMonth(getLastMonth());
			balance.setActualBalance(0f);
			balanceMapper.insertBalance(balance); // 在成功插入balance到数据库后，id已经自动注入到balance中
			return balance; 
		}
		return balanceMapper.selectBalanceInBeginOfMonth(userId);
	}

	/**
	 * 本月末的balance
	 */
	@Override
	public Balance balanceOfThisMonth(int userId) {
		return balanceMapper.selectBalanceOfThisMonth(userId);
	}

	/**
	 * 添加balance
	 */
	@Override
	public void addBalance(float balanceMoney, int userId) {
		Balance balance = new Balance();
		balance.setUserId(userId);
		balance.setActualBalance(balanceMoney);
//		balance.setMonth(LocalDate.now());
		balance.setMonth(new Date());
		balanceMapper.insertBalance(balance);
	}

	// 修改balance
	@Override
	public void changeBalance(int balanceId, float changed_balance) {
		Balance balance = new Balance();
		balance.setId(balanceId);
		balance.setActualBalance(changed_balance);
		balanceMapper.updateByPrimaryKeySelective(balance);
	}

	/**
	 * 获取上个月的时间，只处理年和月，不关心日
	 * JDK1.8已弃用相关Date的方法，所以使用LocalDate来处理
	 * 
	 * 以后把项目中的全部Date替换成LocalDate
	 * 
	 * @return
	 */
	public Date getLastMonth(){
		LocalDate localDate = LocalDate.now();
		localDate = localDate.minusMonths(1);
		// LocalDate 转 Date
	    ZoneId zone = ZoneId.systemDefault();
	    Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
	    Date date = Date.from(instant);
		
		return date;
	}
}
