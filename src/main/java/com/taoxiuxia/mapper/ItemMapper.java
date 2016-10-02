package com.taoxiuxia.mapper;

import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.ItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {

	List<Item> selectIncomeItemByUserId(int id);

	List<Item> selectExpenditureItemByUserId(int id);

	int insert(Item record);

	int updateByPrimaryKeySelective(Item record);

	///////////////////////////////////////////////////////

	List<Item> selectByExample(ItemExample example);

	int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByPrimaryKey(Item record);
}