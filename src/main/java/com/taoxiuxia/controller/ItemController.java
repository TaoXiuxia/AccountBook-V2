package com.taoxiuxia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.service.IItemService;

@Controller
@RequestMapping("/itemController")
public class ItemController {
	private IItemService itemService;

	public IItemService getItemService() {
		return itemService;
	}

	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
	
	/**
	 * 增加item
	 * @param itemName
	 * @param remark
	 */
	@RequestMapping("/addItem")
	public void addIncomeItem(String itemName, String remark) {
		itemService.addItem(itemName, remark, "in");
	}
}
