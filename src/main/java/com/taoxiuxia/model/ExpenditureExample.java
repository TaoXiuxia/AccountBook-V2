package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenditureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenditureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andExpenditureIdIsNull() {
            addCriterion("expenditure_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdIsNotNull() {
            addCriterion("expenditure_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdEqualTo(Integer value) {
            addCriterion("expenditure_id =", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotEqualTo(Integer value) {
            addCriterion("expenditure_id <>", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThan(Integer value) {
            addCriterion("expenditure_id >", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenditure_id >=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThan(Integer value) {
            addCriterion("expenditure_id <", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdLessThanOrEqualTo(Integer value) {
            addCriterion("expenditure_id <=", value, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdIn(List<Integer> values) {
            addCriterion("expenditure_id in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotIn(List<Integer> values) {
            addCriterion("expenditure_id not in", values, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_id between", value1, value2, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_id not between", value1, value2, "expenditureId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdIsNull() {
            addCriterion("expenditure_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdIsNotNull() {
            addCriterion("expenditure_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdEqualTo(Integer value) {
            addCriterion("expenditure_user_id =", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdNotEqualTo(Integer value) {
            addCriterion("expenditure_user_id <>", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdGreaterThan(Integer value) {
            addCriterion("expenditure_user_id >", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenditure_user_id >=", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdLessThan(Integer value) {
            addCriterion("expenditure_user_id <", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("expenditure_user_id <=", value, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdIn(List<Integer> values) {
            addCriterion("expenditure_user_id in", values, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdNotIn(List<Integer> values) {
            addCriterion("expenditure_user_id not in", values, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_user_id between", value1, value2, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_user_id not between", value1, value2, "expenditureUserId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdIsNull() {
            addCriterion("expenditure_item_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdIsNotNull() {
            addCriterion("expenditure_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdEqualTo(Integer value) {
            addCriterion("expenditure_item_id =", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdNotEqualTo(Integer value) {
            addCriterion("expenditure_item_id <>", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdGreaterThan(Integer value) {
            addCriterion("expenditure_item_id >", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenditure_item_id >=", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdLessThan(Integer value) {
            addCriterion("expenditure_item_id <", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("expenditure_item_id <=", value, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdIn(List<Integer> values) {
            addCriterion("expenditure_item_id in", values, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdNotIn(List<Integer> values) {
            addCriterion("expenditure_item_id not in", values, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_item_id between", value1, value2, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expenditure_item_id not between", value1, value2, "expenditureItemId");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyIsNull() {
            addCriterion("expenditure_money is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyIsNotNull() {
            addCriterion("expenditure_money is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyEqualTo(Float value) {
            addCriterion("expenditure_money =", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyNotEqualTo(Float value) {
            addCriterion("expenditure_money <>", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyGreaterThan(Float value) {
            addCriterion("expenditure_money >", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("expenditure_money >=", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyLessThan(Float value) {
            addCriterion("expenditure_money <", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyLessThanOrEqualTo(Float value) {
            addCriterion("expenditure_money <=", value, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyIn(List<Float> values) {
            addCriterion("expenditure_money in", values, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyNotIn(List<Float> values) {
            addCriterion("expenditure_money not in", values, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyBetween(Float value1, Float value2) {
            addCriterion("expenditure_money between", value1, value2, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureMoneyNotBetween(Float value1, Float value2) {
            addCriterion("expenditure_money not between", value1, value2, "expenditureMoney");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateIsNull() {
            addCriterion("expenditure_date is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateIsNotNull() {
            addCriterion("expenditure_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateEqualTo(Date value) {
            addCriterion("expenditure_date =", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateNotEqualTo(Date value) {
            addCriterion("expenditure_date <>", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateGreaterThan(Date value) {
            addCriterion("expenditure_date >", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expenditure_date >=", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateLessThan(Date value) {
            addCriterion("expenditure_date <", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateLessThanOrEqualTo(Date value) {
            addCriterion("expenditure_date <=", value, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateIn(List<Date> values) {
            addCriterion("expenditure_date in", values, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateNotIn(List<Date> values) {
            addCriterion("expenditure_date not in", values, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateBetween(Date value1, Date value2) {
            addCriterion("expenditure_date between", value1, value2, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureDateNotBetween(Date value1, Date value2) {
            addCriterion("expenditure_date not between", value1, value2, "expenditureDate");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkIsNull() {
            addCriterion("expenditure_remark is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkIsNotNull() {
            addCriterion("expenditure_remark is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkEqualTo(String value) {
            addCriterion("expenditure_remark =", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkNotEqualTo(String value) {
            addCriterion("expenditure_remark <>", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkGreaterThan(String value) {
            addCriterion("expenditure_remark >", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("expenditure_remark >=", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkLessThan(String value) {
            addCriterion("expenditure_remark <", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkLessThanOrEqualTo(String value) {
            addCriterion("expenditure_remark <=", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkLike(String value) {
            addCriterion("expenditure_remark like", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkNotLike(String value) {
            addCriterion("expenditure_remark not like", value, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkIn(List<String> values) {
            addCriterion("expenditure_remark in", values, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkNotIn(List<String> values) {
            addCriterion("expenditure_remark not in", values, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkBetween(String value1, String value2) {
            addCriterion("expenditure_remark between", value1, value2, "expenditureRemark");
            return (Criteria) this;
        }

        public Criteria andExpenditureRemarkNotBetween(String value1, String value2) {
            addCriterion("expenditure_remark not between", value1, value2, "expenditureRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}