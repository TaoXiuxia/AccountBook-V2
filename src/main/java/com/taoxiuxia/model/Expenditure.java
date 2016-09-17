package com.taoxiuxia.model;

import java.util.Date;

public class Expenditure {
    private Integer expenditureId;

    private Integer expenditureUserId;

    private Integer expenditureItemId;

    private Float expenditureMoney;

    private Date expenditureDate;

    private String expenditureRemark;

    public Integer getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(Integer expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Integer getExpenditureUserId() {
        return expenditureUserId;
    }

    public void setExpenditureUserId(Integer expenditureUserId) {
        this.expenditureUserId = expenditureUserId;
    }

    public Integer getExpenditureItemId() {
        return expenditureItemId;
    }

    public void setExpenditureItemId(Integer expenditureItemId) {
        this.expenditureItemId = expenditureItemId;
    }

    public Float getExpenditureMoney() {
        return expenditureMoney;
    }

    public void setExpenditureMoney(Float expenditureMoney) {
        this.expenditureMoney = expenditureMoney;
    }

    public Date getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(Date expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    public String getExpenditureRemark() {
        return expenditureRemark;
    }

    public void setExpenditureRemark(String expenditureRemark) {
        this.expenditureRemark = expenditureRemark == null ? null : expenditureRemark.trim();
    }
}