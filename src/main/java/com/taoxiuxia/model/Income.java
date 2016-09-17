package com.taoxiuxia.model;

import java.util.Date;

public class Income {
    private Integer incomeId;

    private Integer incomeUserId;

    private Integer incomeItemId;

    private Float incomeMoney;

    private Date incomeDate;

    private String incomeRemark;

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getIncomeUserId() {
        return incomeUserId;
    }

    public void setIncomeUserId(Integer incomeUserId) {
        this.incomeUserId = incomeUserId;
    }

    public Integer getIncomeItemId() {
        return incomeItemId;
    }

    public void setIncomeItemId(Integer incomeItemId) {
        this.incomeItemId = incomeItemId;
    }

    public Float getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(Float incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeRemark() {
        return incomeRemark;
    }

    public void setIncomeRemark(String incomeRemark) {
        this.incomeRemark = incomeRemark == null ? null : incomeRemark.trim();
    }
}