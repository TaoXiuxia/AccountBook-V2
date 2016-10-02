package com.taoxiuxia.mapper;

import java.util.List;

import com.taoxiuxia.model.Income;

public interface IncomeMapper {

	List<Income> selectAllIncomes();

	int updateByPrimaryKeySelective(Income record);

	int insert(Income record);

	/////////////////////////////////////////////////////////

	int deleteByPrimaryKey(Integer id);

	int insertSelective(Income record);

	Income selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Income record);
}