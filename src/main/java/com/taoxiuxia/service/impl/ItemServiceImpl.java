package com.taoxiuxia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.ItemMapper;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.service.IItemService;

@Service("itemService")
public class ItemServiceImpl implements IItemService {

	private ItemMapper itemMapper;

	public ItemMapper getItemMapper() {
		return itemMapper;
	}

	@Autowired
	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@Override
	public List<Item> loadIncomeItems(int id) {
		return itemMapper.selectIncomeItemByUserId(id);
	}

	@Override
	public List<Item> loadExpenditureItems(int id) {
		return itemMapper.selectExpenditureItemByUserId(id);
	}

	@Override
	public void addItem(String itemName, String remark, String inOrEx) {
		Item item = new Item();
		item.setUserId(2);
		item.setName(itemName);
		item.setInOrEx(inOrEx);
		item.setRemark(remark);
		item.setDele(0);
		itemMapper.insert(item);
	}

}
