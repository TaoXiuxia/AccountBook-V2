package com.taoxiuxia.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.PayMethodMapper;
import com.taoxiuxia.model.PayMethod;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.util.Constants;

@Service("payMethodService")
public class PayMethodServiceImpl implements IPayMethodService {

	private PayMethodMapper payMethodMapper;

	public PayMethodMapper getPayMethodMapper() {
		return payMethodMapper;
	}

	@Autowired
	public void setPayMethodMapper(PayMethodMapper payMethodMapper) {
		this.payMethodMapper = payMethodMapper;
	}

	
	@Override
	public List<PayMethod> loadPayMethods(int id, String inOrEx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", id);
		map.put("inOrEx", inOrEx);
		return payMethodMapper.selectPayMethodsByUserId(map);
	}

	@Override
	public void addPayMethod(int userId, String payMethodName, int isCountInThisMonthEx, String inOrEx, String remark) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("userId", userId);
		parameterMap.put("name", payMethodName);
		parameterMap.put("isCountInThisMonthEx", isCountInThisMonthEx == -1 ? null : isCountInThisMonthEx);
		parameterMap.put("inOrEx", inOrEx);
		parameterMap.put("remark", remark);
		parameterMap.put("dele", Constants.NOT_DELE);
		payMethodMapper.insert(parameterMap);
	}

	@Override
	public void changePayMethod(int payMethodId, String payMethodName, int isCountInThisMonthEx, String remark) {
		PayMethod payMethod  = new PayMethod();
		payMethod.setId(payMethodId);
		payMethod.setName(payMethodName);
		payMethod.setIsCountInThisMonthEx(isCountInThisMonthEx==-1?null:isCountInThisMonthEx);
		payMethod.setRemark(remark);
		payMethodMapper.updateByPrimaryKeySelective(payMethod);
	}

	@Override
	public void delePayMethod(int payMethodId) {
		PayMethod payMethod = new PayMethod();
		payMethod.setId(payMethodId);
		payMethod.setDele(Constants.DELE);
		payMethodMapper.updateByPrimaryKeySelective(payMethod);
	}

	@Override
	public String upAndDownPayMethod(int userId, int payMethodId, String inOrEx, String upAndDown) {
		List<PayMethod> payMethodList = new ArrayList<PayMethod>();
		if("ex".equals(inOrEx)){
			payMethodList = loadPayMethods(userId,"ex");
		}else if("in".equals(inOrEx)){
			payMethodList = loadPayMethods(userId,"in");
		}else{
			return "输入参数不合法";
		}
		
		int listSize = payMethodList.size();
		
		int[]payMethodIdArray = new int[listSize];
		int[]sortArray = new int[listSize];
		
		// 先把item的id与sort单独取出来并存放在数组中，然后操作数组
		for(int i=0;i<listSize;i++){
			payMethodIdArray[i] = payMethodList.get(i).getId();
			sortArray[i] = payMethodList.get(i).getSort();
		}
		
		int curI = 0;
		for(int i=0;i<listSize;i++){
			if(payMethodId == payMethodIdArray[i]){
				curI = i;
				break;
			}
		}
		if(curI == 0 && "up".equals(upAndDown)){
			return "已经是第一个了，无法上移";
		}
		if(curI == (listSize-1) && "down".equals(upAndDown)){
			return "已经是最后一个了，无法下移";
		}
		
		// 将该payMethod的sort与其上一个的payMethod sort互换
		if("up".equals(upAndDown)){
			exchange(userId,payMethodIdArray[curI], sortArray[curI],payMethodIdArray[curI-1], sortArray[curI-1]);
			return "上移成功";
		}
		// 将该payMethod的sort与其下一个的payMethod sort互换
		if("down".equals(upAndDown)){
			exchange(userId,payMethodIdArray[curI], sortArray[curI],payMethodIdArray[curI+1], sortArray[curI+1]);
			return "下移成功";
		}
		
		return "上移或下移失败";
	}
	
	/**
	 * 交换itemId1和itemId2的sort
	 * @param payMethodId1
	 * @param sort1
	 * @param payMethodId2
	 * @param sort2
	 */
	public void exchange(int userId, int payMethodId1, int sort1, int payMethodId2, int sort2){
		PayMethod payMethod = new PayMethod();
		payMethod.setId(payMethodId1);
		payMethod.setSort(sort2);
		payMethodMapper.updateByPrimaryKeySelective(payMethod);
		
		payMethod.setId(payMethodId2);
		payMethod.setSort(sort1);
		payMethodMapper.updateByPrimaryKeySelective(payMethod);
	}
}
