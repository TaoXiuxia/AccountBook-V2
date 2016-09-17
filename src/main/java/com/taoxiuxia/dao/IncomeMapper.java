package com.taoxiuxia.dao;

import com.taoxiuxia.model.Income;
import com.taoxiuxia.model.IncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeMapper {
    int countByExample(IncomeExample example);

    int deleteByExample(IncomeExample example);

    int deleteByPrimaryKey(Integer incomeId);

    int insert(Income record);

    int insertSelective(Income record);

    List<Income> selectByExample(IncomeExample example);
    
    List<Income> selectAll();

    Income selectByPrimaryKey(Integer incomeId);

    int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByExample(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
}