package com.taoxiuxia.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.ExpenditureMapper;
import com.taoxiuxia.model.Expenditure;
import com.taoxiuxia.model.Income;
import com.taoxiuxia.service.IExpenditureService;
import com.taoxiuxia.util.MyDateFormat;

@Service("expenditureService")
public class ExpenditureServiceImpl implements IExpenditureService {

	private ExpenditureMapper expenditureMapper;

	public ExpenditureMapper getExpenditureMapper() {
		return expenditureMapper;
	}

	@Autowired
	public void setExpenditureMapper(ExpenditureMapper expenditureMapper) {
		this.expenditureMapper = expenditureMapper;
	}

	@Override
	public List<Expenditure> loadExpenditures() {
		return expenditureMapper.selectAllExpenditures();
	}

	@Override
	public void addExpenditure(String date, int item, float money, String moneyType, String remark) {
		Expenditure expenditure = new Expenditure();
		expenditure.setItemId(item);
		expenditure.setUserId(2); 
		expenditure.setDele(0);
		expenditure.setMoney(money);
		expenditure.setType_of_money(moneyType);
		expenditure.setDate(MyDateFormat.dateFormat(date));
		expenditure.setRemark(remark);
		expenditureMapper.insert(expenditure);
	}

	@Override
	public void changeExpenditure(int expenditureId, float money, String moneyType, int itemId, String remark,Date date) {
		Expenditure expenditure = new Expenditure();
		expenditure.setDele(0);
		expenditure.setUserId(2); // 如果不设置会自动设置成0，为什么？？
		expenditure.setId(expenditureId);
		expenditure.setItemId(itemId);
		expenditure.setMoney(money);
		expenditure.setType_of_money(moneyType);
		expenditure.setRemark(remark);
		expenditure.setDate(date);
		expenditureMapper.updateByPrimaryKeySelective(expenditure);
	}

	@Override
	public void deleExpenditure(int expenditureId, int itemId) {
		Expenditure expenditure = new Expenditure();
		expenditure.setId(expenditureId);
		expenditure.setDele(1);
		expenditure.setDate(null);
		expenditure.setUserId(2); // 如果不设置会自动设置成0，为什么？？
		expenditure.setItemId(itemId);  // 正常应该这里不设置，但是因为会自动设置成0，所以从前台传itemid进来
		expenditure.setMoney(null);
		expenditure.setRemark(null);
		expenditureMapper.updateByPrimaryKeySelective(expenditure);
	}

}
