package com.taoxiuxia.mapper;

import com.taoxiuxia.model.PayMethod;
import com.taoxiuxia.model.PayMethodExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PayMethodMapper {
	
	/**
	 * 根据用户的id查找该用户设置的收入或支出方式
	 * @param map
	 * @return
	 */
	List<PayMethod> selectPayMethodsByUserId(Map<String,Object> map);

	/**
	 * 修改PayMethod, 和删除PayMethod
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(PayMethod record);
	
	/**
	 * 插入PayMethod
	 * @param record
	 * @return
	 */
	Map<String, Object> insert(Map<String, Object> map);
	
	
	
	/////////////////////////////////////////////////////////////
	
    int countByExample(PayMethodExample example);

    int deleteByExample(PayMethodExample example);

    int deleteByPrimaryKey(Integer id);


    int insertSelective(PayMethod record);

    List<PayMethod> selectByExample(PayMethodExample example);

    PayMethod selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMethod record, @Param("example") PayMethodExample example);

    int updateByExample(@Param("record") PayMethod record, @Param("example") PayMethodExample example);


    int updateByPrimaryKey(PayMethod record);
}