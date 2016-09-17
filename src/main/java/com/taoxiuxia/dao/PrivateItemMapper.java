package com.taoxiuxia.dao;

import com.taoxiuxia.model.PrivateItem;
import com.taoxiuxia.model.PrivateItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivateItemMapper {
    int countByExample(PrivateItemExample example);

    int deleteByExample(PrivateItemExample example);

    int deleteByPrimaryKey(Integer privateItemId);

    int insert(PrivateItem record);

    int insertSelective(PrivateItem record);

    List<PrivateItem> selectByExample(PrivateItemExample example);

    PrivateItem selectByPrimaryKey(Integer privateItemId);

    int updateByExampleSelective(@Param("record") PrivateItem record, @Param("example") PrivateItemExample example);

    int updateByExample(@Param("record") PrivateItem record, @Param("example") PrivateItemExample example);

    int updateByPrimaryKeySelective(PrivateItem record);

    int updateByPrimaryKey(PrivateItem record);
}