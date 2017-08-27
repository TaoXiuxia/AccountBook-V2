package com.taoxiuxia.service;

import java.util.List;

import com.taoxiuxia.model.Item;

public interface IItemService {

	/**
	 * 加载全部income item,用于用户选择
	 * @return
	 */
	List<Item> loadIncomeItems(int id);
	
	/**
	 * 加载全部expenditure item,用于用户选择
	 * @return
	 */
	List<Item> loadExpenditureItems(int id);
	
	/**
	 * 增加项，income or expenditure
	 * @param inOrEx
	 */
	void addItem(int userId, String itemName, String remark, String inOrEx);
	
	/**
	 * 修改item，能够被修改的项只有itemName remark
	 * 修改item只需要itemId定位到item就可以了，不需要userId inOrEx sort字段
	 */
	void changeItem(int itemId, String itemName, String remark);
	
	/**
	 * 修改item 只需要itemId定位到item就可以了，其他的字段都不需要
	 */
	void deleItem(int itemId);
	
	/**
	 * 上移下移item
	 * @param userId
	 * @param itemId
	 * @param inOrEx
	 * @param upAndDown
	 * @return
	 */
	String upAndDownItem(int userId, int itemId,  String inOrEx, String upAndDown);
}
