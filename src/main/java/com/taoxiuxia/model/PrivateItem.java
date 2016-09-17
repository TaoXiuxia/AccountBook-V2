package com.taoxiuxia.model;

public class PrivateItem {
    private Integer privateItemId;

    private Integer privateItemUserId;

    private String privateItemName;

    private String privateItemInOrEx;

    private String privateItemRemark;

    public Integer getPrivateItemId() {
        return privateItemId;
    }

    public void setPrivateItemId(Integer privateItemId) {
        this.privateItemId = privateItemId;
    }

    public Integer getPrivateItemUserId() {
        return privateItemUserId;
    }

    public void setPrivateItemUserId(Integer privateItemUserId) {
        this.privateItemUserId = privateItemUserId;
    }

    public String getPrivateItemName() {
        return privateItemName;
    }

    public void setPrivateItemName(String privateItemName) {
        this.privateItemName = privateItemName == null ? null : privateItemName.trim();
    }

    public String getPrivateItemInOrEx() {
        return privateItemInOrEx;
    }

    public void setPrivateItemInOrEx(String privateItemInOrEx) {
        this.privateItemInOrEx = privateItemInOrEx == null ? null : privateItemInOrEx.trim();
    }

    public String getPrivateItemRemark() {
        return privateItemRemark;
    }

    public void setPrivateItemRemark(String privateItemRemark) {
        this.privateItemRemark = privateItemRemark == null ? null : privateItemRemark.trim();
    }
}