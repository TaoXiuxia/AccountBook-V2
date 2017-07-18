package com.taoxiuxia.mapper;

import com.taoxiuxia.model.Balance;
import com.taoxiuxia.model.BalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
	
	/**
	 * 本月收入
	 * @param userId
	 * @return
	 */
	float selectMonthlyIncome(int userId);
	
	/**
	 * 本月支出
	 * @param userId
	 * @return
	 */
	float selectMonthlyExpenditure(int userId);
	
	/**
	 * 本月支出中花呗与信用卡的数额
	 * 
	 * @param userId
	 * @return
	 */
	float selectHuaBeiAndCreditCard(int userId);
	
	/**
	 * 查询月初结余，即上月末结余
	 * @param userId
	 * @return
	 */
	float selectBalanceInBeginOfMonth(int userId);
	
	/**
	 * 查询本月结余，如果有就返回实际值，如果没有就返回null
	 * @param userId
	 * @return
	 */
	Balance selectBalanceOfThisMonth(int userId);
	
	/**
	 * 向数据库中插入本月实际的结余（由于种种原因，实际的结余总是与记录的数有出入，比如忘记记录）
	 * 每月只能插入一次，第一次插入，之后都是修改
	 * @param balance
	 */
	void insertBalance(Balance balance);
	
	/**
	 * 修改本月结余
	 * @param balance
	 */
	void updateByPrimaryKeySelective(Balance balance);
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////
	
    int countByExample(BalanceExample example);

    int deleteByExample(BalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Balance record);

    int insertSelective(Balance record);

    List<Balance> selectByExample(BalanceExample example);

    Balance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByExample(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByPrimaryKey(Balance record);
}