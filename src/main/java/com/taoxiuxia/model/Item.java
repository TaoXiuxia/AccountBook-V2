package com.taoxiuxia.model;

public class Item {
    private Integer id;

    private Integer userId;

    private String name;

    private String inOrEx;

    private String remark;

    private Integer dele;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInOrEx() {
        return inOrEx;
    }

    public void setInOrEx(String inOrEx) {
        this.inOrEx = inOrEx == null ? null : inOrEx.trim();
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