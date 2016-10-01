package com.taoxiuxia.mapper;

import com.taoxiuxia.model.Income;
import com.taoxiuxia.model.IncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeMapper {

	List<Income> selectAllIncomes();

	int updateByPrimaryKeySelective(Income record);

	int insert(Income record);

	/////////////////////////////////////////////////////////
	
	int countByExample(IncomeExample example);

	int deleteByExample(IncomeExample example);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(Income record);

	List<Income> selectByExample(IncomeExample example);

	Income selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeExample example);

	int updateByExample(@Param("record") Income record, @Param("example") IncomeExample example);

	int updateByPrimaryKey(Income record);
}