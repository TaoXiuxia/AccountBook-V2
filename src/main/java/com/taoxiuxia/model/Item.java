package com.taoxiuxia.model;

public class Item {
    private Integer id;

    private int userId;
    
    private String name;
    
    private String inOrEx;

    private String remark;

    private int dele;
    
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getInOrEx() {
		return inOrEx;
	}

	public void setInOrEx(String inOrEx) {
		this.inOrEx = inOrEx;
	}

	public int getDele() {
		return dele;
	}

	public void setDele(int dele) {
		this.dele = dele;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}