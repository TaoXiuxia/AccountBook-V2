package com.taoxiuxia.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.service.IExpenditureService;
import com.taoxiuxia.service.IHistoryService;
import com.taoxiuxia.service.IIncomeService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.MyDateFormat;

@Controller
@RequestMapping("/historyController")
public class HistoryController {

	private IIncomeService incomeService;
	private IExpenditureService expenditureService;
	private IItemService itemService;
	private IHistoryService historyService;

	public IHistoryService getHistoryService() {
		return historyService;
	}

	@Autowired
	public void setHistoryService(IHistoryService historyService) {
		this.historyService = historyService;
	}

	public IExpenditureService getExpenditureService() {
		return expenditureService;
	}

	@Autowired
	public void setExpenditureService(IExpenditureService expenditureService) {
		this.expenditureService = expenditureService;
	}

	public IIncomeService getIncomeService() {
		return incomeService;
	}

	@Autowired
	public void setIncomeService(IIncomeService incomeService) {
		this.incomeService = incomeService;
	}

	public IItemService getItemService() {
		return itemService;
	}

	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * history页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showhistory")
	public String showHistory(Model model,HttpSession session) {
		// 初始页面，显示当前用户的全部数据
		int limit = Constants.LIMIT;
		int totalRecords = historyService.countIncomesAndExpenditure(2, null, -1, -1, null); // 初始条件下 根据条件查到的记录的总条数
		int totalPages = (int) Math.ceil(totalRecords*1.0/limit);  // 初始条件下 总页数
		List<Map> historys = historyService.loadIncomesAndExpenditure(2, null, -1, -1, null, "date DESC", 1, totalPages );
		List<Item> incomesItems = itemService.loadIncomeItems(2); // 目前只有用户2
		List<Item> expenditureItems = itemService.loadExpenditureItems(2); // 目前只有用户2
		
		model.addAttribute("incomesItems", incomesItems);
		model.addAttribute("expenditureItems", expenditureItems);
		model.addAttribute("historys", historys);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("curPage", 1);  // 当前页码
		
		SessionUser sessionUser= (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		model.addAttribute("sessionUser", sessionUser);
		return "pages/history";
	}

	/**
	 * 
	 * 搜索，返回json数据
	 * 
	 * @param model
	 * @param type 支出/收入 ex/in
	 * @param year 年份
	 * @param month 月份
	 * @param keyword 关键词
	 * @param sortBy 排序方式
	 * @param Curpage 当前页
	 * @return
	 */
	@RequestMapping(value = "/searchHistory", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> searchHistory(Model model, String type, int year, int month, String keyword, String sortBy, int curPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int limit = Constants.LIMIT;
		int totalRecords = historyService.countIncomesAndExpenditure(2, type.equals("all") ? null : type, year, month, keyword); // 根据条件查到的记录的总条数
		int totalPages = (int) Math.ceil(totalRecords*1.0/limit);  // 总页数
		
		if(totalRecords==0){ //如果查到0条数据，就不需要后序的操作了
			map.put("list", null);   // 查询到的全部历史记录的list
			map.put("dateList", null);  // 相应历史记录的日期的list
			map.put("typeList", null);  // 相应历史纪录的类型的list
			map.put("totalPages", 0); // 全部页数
			map.put("totalRecords", 0); // 全部条数
			map.put("curPage", 0);  // 当前页码
			return map; // 返回的是已经转化过的json数据
		}
		
		List<Map> historys = historyService.loadIncomesAndExpenditure(2, type.equals("all") ? null : type, year, month, keyword, sortBy, curPage, totalPages);
		
		// 后台处理日期
		List<String> dateList = new ArrayList<String>();
		for (Map history : historys) {
			Date date = (Date) history.get("date");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year1 = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH) + 1;
			int day1 = cal.get(Calendar.DATE);
			dateList.add(year1 + "-" + (month1 < 10 ? ("0" + month1) : month1) + "-" + (day1 < 10 ? ("0" + day1) : day1));
		}

		// 后台处理 类型type
		List<String> typeList = new ArrayList<String>();
		for (Map history : historys) {
			String type1 = (String) history.get("itemType");
			typeList.add(type1.equals("ex") ? "支出" : "收入");
		}
		map.put("list", historys);   // 查询到的全部历史记录的list
		map.put("dateList", dateList);  // 相应历史记录的日期的list
		map.put("typeList", typeList);  // 相应历史纪录的类型的list
		map.put("totalPages", totalPages); // 全部页数
		map.put("totalRecords", totalRecords); // 全部条数
		map.put("curPage", curPage);  // 当前页码
		return map; // 返回的是已经转化过的json数据
	}

	/**
	 * 修改history，可能是income或者expenditure
	 * 
	 * @param itemType
	 * @param changedType
	 * @param detailsId
	 * @param changedDate
	 * @param changedMoney
	 * @param changedItem
	 * @param changedRemark
	 * @return
	 */
	@RequestMapping("/changeHistory")
	public void changeHistory(String itemType, String changedType, int detailsId, String changedDate,
			float changedMoney, String changedMoneyType, int changedItem, String changedRemark) {
		
		if (itemType.equals(changedType)) { // 同一个类目下修改
			if (itemType.equals("in")) {
				incomeService.changeIncome(detailsId, changedMoney, changedMoneyType, changedItem, changedRemark, MyDateFormat.dateFormat(changedDate));
			} else {
				expenditureService.changeExpenditure(detailsId, changedMoney, changedMoneyType, changedItem, changedRemark, MyDateFormat.dateFormat(changedDate));
			}
		} else { // 不同的类目下，先删除原来的，在添加上新的
			if (changedType.equals("in")) { // 原来是ex，现在是in
				incomeService.addIncome(changedDate, changedItem, changedMoney,changedMoneyType, changedRemark);
				expenditureService.deleExpenditure(detailsId, changedItem);
			}else{ // 原来是in，现在是ex
				expenditureService.addExpenditure(changedDate, changedItem, changedMoney,changedMoneyType, changedRemark);
				incomeService.deleIncome(detailsId, changedItem);
			}
		}
	}

	/**
	 * 删除history，可能是income或者expenditure
	 * @param itemType
	 * @param itemId
	 */
	@RequestMapping("/deleHistory")
	public void deleteHistory(String itemType, int historyId, int itemId) {
		if (itemType.equals("in")) { // 删除income
			incomeService.deleIncome(historyId, itemId);
		} else { // 删除expenditure
			expenditureService.deleExpenditure(historyId, itemId);
		}
	}
}
