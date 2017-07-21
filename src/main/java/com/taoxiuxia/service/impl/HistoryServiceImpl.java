package com.taoxiuxia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.IncomeMapper;
import com.taoxiuxia.service.IHistoryService;
import com.taoxiuxia.util.Constants;

@Service("historyService")
public class HistoryServiceImpl implements IHistoryService {

	private IncomeMapper incomeMapper;

	public IncomeMapper getIncomeMapper() {
		return incomeMapper;
	}

	@Autowired
	public void setIncomeMapper(IncomeMapper incomeMapper) {
		this.incomeMapper = incomeMapper;
	}

	@Override
	public List<Map> loadIncomesAndExpenditure(int userId,String inOrEx, int year, int month, String keyword, String sortBy, int curPage, int totalPages)  {
		int limit = Constants.LIMIT;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(year!=-1){
			if(month!=-1){ //指定了年份和月份
				String monthStr;
				if(month<10){
					monthStr="0"+month;
				}else{
					monthStr=""+month;
				}
				map.put("beginDate", year+"-"+monthStr+"-01");
				map.put("endDate", year+"-"+monthStr+"-30");  // 数据库中是按照月份查的，因此最后的日期项无所谓
			}else{ // 只指定了年份，没有指定月份
				map.put("beginDate", year+"-01-01");
				map.put("endDate", year+"-12-30");
			}
		}else{ //没有指定时间
			map.put("beginDate", null);
			map.put("endDate", null);
		}
		map.put("inOrEx", inOrEx);
		map.put("userId", userId);
		map.put("keyword", keyword);
		
		if (curPage < 1){  
			curPage = 1;  
	    }else if (curPage > totalPages){  
	    	curPage = totalPages;  
	    } 
	    
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("curPage"+curPage);
		System.out.println("totalPages"+totalPages);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		
	    map.put("sortBy", sortBy);
		map.put("beginRecord", (curPage-1)*limit);
		map.put("limit", limit);
		List<Map>list = incomeMapper.selectIncomesAndExpenditure(map);
		return list;
	}
	
	@Override
	public int countIncomesAndExpenditure(int userId,String inOrEx,int year, int month, String keyword){
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(year!=-1){
			if(month!=-1){ //指定了年份和月份
				String monthStr;
				if(month<10){
					monthStr="0"+month;
				}else{
					monthStr=""+month;
				}
				map.put("beginDate", year+"-"+monthStr+"-01");
				map.put("endDate", year+"-"+monthStr+"-30");  // 数据库中是按照月份查的，因此最后的日期项无所谓
			}else{ // 只指定了年份，没有指定月份
				map.put("beginDate", year+"-01-01");
				map.put("endDate", year+"-12-30");
			}
		}else{ //没有指定时间
			map.put("beginDate", null);
			map.put("endDate", null);
		}
		map.put("inOrEx", inOrEx);
		map.put("userId", userId);
		map.put("keyword", keyword);
		
		return incomeMapper.countIncomesAndExpenditure(map); // 根据条件查到的记录的总条数
	}
	

}
