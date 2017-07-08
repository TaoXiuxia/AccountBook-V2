package com.taoxiuxia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.util.Constants;

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
	 * income页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showManageItems")
	public String showManageItems(Model model,HttpSession session) {
		List<Item> expenditureItems = itemService.loadExpenditureItems(2); // 目前只有用户2
		List<Item> incomeItems = itemService.loadIncomeItems(2);
		model.addAttribute("expenditureItems", expenditureItems);
		model.addAttribute("incomeItems", incomeItems);
		
		SessionUser sessionUser= (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		model.addAttribute("sessionUser", sessionUser);
		
		return "pages/manageItems";
	}

	/**
	 * 增加item
	 * 
	 * @param itemName
	 * @param remark
	 */
	@RequestMapping("/addItem")
	public void addItem(String itemName, String remark, String inOrEx) {
		itemService.addItem(itemName, remark, inOrEx);
	}

	/**
	 * 修改item
	 * 
	 * @param itemId
	 * @param itemName
	 * @param remark
	 * @param inOrEx
	 */
	@RequestMapping("/changeItem")
	public void changeItem(int itemId, String itemName, String remark, String inOrEx) {
		itemService.changeItem(itemId, itemName, remark, inOrEx);
	}
	
	/**
	 * 删除item
	 * @param itemId
	 */
	@RequestMapping("/deleItem")
	public void deleItem(int itemId) {
		itemService.deleItem(itemId);
	}

}
