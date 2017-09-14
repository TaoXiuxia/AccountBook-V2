package com.taoxiuxia.model;

import java.util.Date;

public class Expenditure {
    private Integer id;

    private Integer itemId;
    
    private String itemName;

    private Integer userId;

    private Float money;

    private String type_of_money;
    
    private Date date;

    private String remark;

    private Integer dele;

    private String payMethodName;
    
	public String getPayMethodName() {
		return payMethodName;
	}

	public void setPayMethodName(String payMethodName) {
		this.payMethodName = payMethodName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getType_of_money() {
		return type_of_money;
	}

	public void setType_of_money(String type_of_money) {
		this.type_of_money = type_of_money;
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDele() {
        return dele;
    }

    public void setDele(Integer dele) {
        this.dele = dele;
    }
}