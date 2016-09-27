package com.taoxiuxia.mapper;

import com.taoxiuxia.model.Expenditure;
import com.taoxiuxia.model.ExpenditureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenditureMapper {
    int countByExample(ExpenditureExample example);

    int deleteByExample(ExpenditureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Expenditure record);

    int insertSelective(Expenditure record);

    List<Expenditure> selectByExample(ExpenditureExample example);

    Expenditure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    int updateByExample(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    int updateByPrimaryKeySelective(Expenditure record);

    int updateByPrimaryKey(Expenditure record);
}