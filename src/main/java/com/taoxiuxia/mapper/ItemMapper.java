package com.taoxiuxia.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.ItemExample;

public interface ItemMapper {

	List<Item> selectIncomeItemByUserId(int id);

	List<Item> selectExpenditureItemByUserId(int id);

	/*int insert(Item record);*/

	Map<String, Object> insert(Map<String, Object> map);
	
	int updateByPrimaryKeySelective(Item record);

	///////////////////////////////////////////////////////

	List<Item> selectByExample(ItemExample example);

	int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByPrimaryKey(Item record);
}