package com.taoxiuxia.model;

import java.util.Date;

public class Borrow {
    private Integer borrowId;

    private Integer borrowUserId;

    private String borrowName;

    private Integer borrowMoney;

    private String borrowType;

    private Date borrowDate;

    private String borrowRemark;

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName == null ? null : borrowName.trim();
    }

    public Integer getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Integer borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(String borrowType) {
        this.borrowType = borrowType == null ? null : borrowType.trim();
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowRemark() {
        return borrowRemark;
    }

    public void setBorrowRemark(String borrowRemark) {
        this.borrowRemark = borrowRemark == null ? null : borrowRemark.trim();
    }
}