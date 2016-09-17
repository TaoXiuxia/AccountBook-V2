package com.taoxiuxia.dao;

import com.taoxiuxia.model.PublicItem;
import com.taoxiuxia.model.PublicItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublicItemMapper {
    int countByExample(PublicItemExample example);

    int deleteByExample(PublicItemExample example);

    int deleteByPrimaryKey(Integer publicItemId);

    int insert(PublicItem record);

    int insertSelective(PublicItem record);

    List<PublicItem> selectByExample(PublicItemExample example);

    PublicItem selectByPrimaryKey(Integer publicItemId);

    int updateByExampleSelective(@Param("record") PublicItem record, @Param("example") PublicItemExample example);

    int updateByExample(@Param("record") PublicItem record, @Param("example") PublicItemExample example);

    int updateByPrimaryKeySelective(PublicItem record);

    int updateByPrimaryKey(PublicItem record);
}