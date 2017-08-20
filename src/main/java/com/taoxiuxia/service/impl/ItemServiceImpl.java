package com.taoxiuxia.service.impl;

import java.util.ArrayList;
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
	public void addItem(int userId, String itemName, String remark, String inOrEx) {
		Item item = new Item();
		item.setUserId(userId);
		item.setName(itemName);
		item.setInOrEx(inOrEx);
		item.setRemark(remark);
		item.setDele(0);
		item.setSort(0);
		int itemId = itemMapper.insert(item);
		item.setSort(item.getId());
		itemMapper.updateByPrimaryKeySelective(item);
	}

	@Override
	public void changeItem(int itemId, String itemName, String remark, String inOrEx) {
		Item item = new Item();
		item.setId(itemId);
		item.setUserId(2);
		item.setName(itemName);
		item.setInOrEx(inOrEx);
		item.setRemark(remark);
		item.setDele(0);
		itemMapper.updateByPrimaryKeySelective(item);
	}

	@Override
	public void deleItem(int itemId) {
		Item item = new Item();
		item.setId(itemId);
		item.setUserId(2);
		item.setDele(1);
		itemMapper.updateByPrimaryKeySelective(item);
	}

	/**
	 * 上移下移item
	 * @param userId
	 * @param itemId
	 * @param inOrEx
	 * @param upAndDown
	 * @return
	 */
	@Override
	public String upAndDownItem(int userId, int itemId, String inOrEx, String upAndDown) {
		List<Item> itemList = new ArrayList<Item>();
		if("ex".equals(inOrEx)){
			itemList = loadExpenditureItems(userId);
		}else if("in".equals(inOrEx)){
			itemList = loadIncomeItems(userId);
		}else{
			return "输入参数不合法";
		}
		
		int listSize = itemList.size();
		
		int[]itemIdArray = new int[listSize];
		int[]sortArray = new int[listSize];
		
		// 先把item的id与sort单独取出来并存放在数组中，然后操作数组
		for(int i=0;i<listSize;i++){
			itemIdArray[i] = itemList.get(i).getId();
			sortArray[i] = itemList.get(i).getSort();
		}
		
		int curI = 0;
		for(int i=0;i<listSize;i++){
			if(itemId == itemIdArray[i]){
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
		
		// 将该item的sort与其上一个的item sort互换
		if("up".equals(upAndDown)){
			exchange(userId,itemIdArray[curI], sortArray[curI],itemIdArray[curI-1], sortArray[curI-1]);
			return "上移成功";
		}
		// 将该item的sort与其下一个的item sort互换
		if("down".equals(upAndDown)){
			exchange(userId,itemIdArray[curI], sortArray[curI],itemIdArray[curI+1], sortArray[curI+1]);
			return "下移成功";
		}
		
		return "上移或下移失败";
	}
	
	/**
	 * 交换itemId1和itemId2的sort
	 * @param itemId1
	 * @param sort1
	 * @param itemId2
	 * @param sort2
	 */
	public void exchange(int userId, int itemId1, int sort1, int itemId2, int sort2){
		Item item = new Item();
		item.setId(itemId1);
		item.setUserId(userId);
		item.setSort(sort2);
		itemMapper.updateByPrimaryKeySelective(item);
		
		item.setId(itemId2);
		item.setSort(sort1);
		item.setUserId(userId);
		itemMapper.updateByPrimaryKeySelective(item);
	}
}
