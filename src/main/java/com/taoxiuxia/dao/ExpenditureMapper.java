package com.taoxiuxia.dao;

import com.taoxiuxia.model.Expenditure;
import com.taoxiuxia.model.ExpenditureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenditureMapper {
    int countByExample(ExpenditureExample example);

    int deleteByExample(ExpenditureExample example);

    int deleteByPrimaryKey(Integer expenditureId);

    int insert(Expenditure record);

    int insertSelective(Expenditure record);

    List<Expenditure> selectByExample(ExpenditureExample example);

    Expenditure selectByPrimaryKey(Integer expenditureId);

    int updateByExampleSelective(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    int updateByExample(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    int updateByPrimaryKeySelective(Expenditure record);

    int updateByPrimaryKey(Expenditure record);
}