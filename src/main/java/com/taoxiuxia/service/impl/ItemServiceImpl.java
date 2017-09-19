package com.taoxiuxia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoxiuxia.mapper.ItemMapper;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.util.Constants;

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

	/**
	 * 加载income项
	 */
	@Override
	public List<Item> loadIncomeItems(int id) {
		return itemMapper.selectIncomeItemByUserId(id);
	}

	/**
	 * 加载expenditure项
	 */
	@Override
	public List<Item> loadExpenditureItems(int id) {
		return itemMapper.selectExpenditureItemByUserId(id);
	}

	/**
	 * 添加item
	 */
	@Override
	public void addItem(int userId, String itemName, String remark, String inOrEx) {
		Item item = new Item();
		item.setUserId(userId);
		item.setName(itemName);
		item.setInOrEx(inOrEx);
		item.setRemark(remark);
		item.setDele(Constants.NOT_DELE);
		itemMapper.insert(item);
		item.setSort(item.getId());
		itemMapper.updateByPrimaryKeySelective(item);
	}

	/**
	 * 修改item，能够被修改的项只有itemName remark
	 * 修改item只需要itemId定位到item就可以了，不需要userId inOrEx sort字段
	 */
	@Override
	public void changeItem(int itemId, String itemName, String remark) {
		Item item = new Item();
		item.setId(itemId);
		item.setName(itemName);
		item.setRemark(remark);
		itemMapper.updateByPrimaryKeySelective(item);
	}

	/**
	 * 修改item 只需要itemId定位到item就可以了，其他的字段都不需要
	 */
	@Override
	public void deleItem(int itemId) {
		Item item = new Item();
		item.setId(itemId);
		item.setDele(Constants.DELE); // 删除
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
		if(curI == (listSize - 1) && "down".equals(upAndDown)){
			return "已经是最后一个了，无法下移";
		}
		
		// 将该item的sort与其上一个的item sort互换
		if("up".equals(upAndDown)){
			exchange(userId,itemIdArray[curI], sortArray[curI],itemIdArray[curI - 1], sortArray[curI - 1]);
			return "上移成功";
		}
		// 将该item的sort与其下一个的item sort互换
		if("down".equals(upAndDown)){
			exchange(userId,itemIdArray[curI], sortArray[curI],itemIdArray[curI + 1], sortArray[curI + 1]);
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
		item.setSort(sort2);
		itemMapper.updateByPrimaryKeySelective(item);
		
		item.setId(itemId2);
		item.setSort(sort1);
		itemMapper.updateByPrimaryKeySelective(item);
	}
}
