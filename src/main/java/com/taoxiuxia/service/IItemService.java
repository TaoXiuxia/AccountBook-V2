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
	void addItem(String itemName, String remark, String inOrEx);
	
	/**
	 * 修改item
	 * @param itemId
	 * @param itemName
	 * @param remark
	 * @param inOrEx
	 */
	void changeItem(int itemId, String itemName, String remark, String inOrEx);
	
	/**
	 * 删除item
	 * @param itemId
	 */
	void deleItem(int itemId);
}
