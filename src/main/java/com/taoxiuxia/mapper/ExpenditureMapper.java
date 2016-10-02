package com.taoxiuxia.mapper;

import java.util.List;

import com.taoxiuxia.model.Expenditure;

public interface ExpenditureMapper {

	List<Expenditure> selectAllExpenditures();

	int updateByPrimaryKeySelective(Expenditure record);

	int insert(Expenditure record);

	////////////////////////////////////////////////////////////////

	int deleteByPrimaryKey(Integer id);

	int insertSelective(Expenditure record);

	Expenditure selectByPrimaryKey(Integer id);
}