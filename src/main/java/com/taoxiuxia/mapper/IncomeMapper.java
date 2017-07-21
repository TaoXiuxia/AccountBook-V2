package com.taoxiuxia.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taoxiuxia.model.Income;

public interface IncomeMapper {

	List<Income> selectAllIncomes();
	
	List<Map> selectIncomesAndExpenditure(HashMap map);
	
	int countIncomesAndExpenditure(HashMap map);

	int updateByPrimaryKeySelective(Income record);

	int insert(Income record);
	
	/////////////////////////////////////////////////////////

	int deleteByPrimaryKey(Integer id);

	int insertSelective(Income record);

	Income selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Income record);
}