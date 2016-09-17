package com.taoxiuxia.model;

public class PublicItem {
    private Integer publicItemId;

    private String publicItemName;

    private String publicItemInOrEx;

    private String publicItemRemark;

    public Integer getPublicItemId() {
        return publicItemId;
    }

    public void setPublicItemId(Integer publicItemId) {
        this.publicItemId = publicItemId;
    }

    public String getPublicItemName() {
        return publicItemName;
    }

    public void setPublicItemName(String publicItemName) {
        this.publicItemName = publicItemName == null ? null : publicItemName.trim();
    }

    public String getPublicItemInOrEx() {
        return publicItemInOrEx;
    }

    public void setPublicItemInOrEx(String publicItemInOrEx) {
        this.publicItemInOrEx = publicItemInOrEx == null ? null : publicItemInOrEx.trim();
    }

    public String getPublicItemRemark() {
        return publicItemRemark;
    }

    public void setPublicItemRemark(String publicItemRemark) {
        this.publicItemRemark = publicItemRemark == null ? null : publicItemRemark.trim();
    }
}