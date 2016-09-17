package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncomeExample() {
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

        public Criteria andIncomeIdIsNull() {
            addCriterion("income_id is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIdIsNotNull() {
            addCriterion("income_id is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeIdEqualTo(Integer value) {
            addCriterion("income_id =", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotEqualTo(Integer value) {
            addCriterion("income_id <>", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdGreaterThan(Integer value) {
            addCriterion("income_id >", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_id >=", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdLessThan(Integer value) {
            addCriterion("income_id <", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("income_id <=", value, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdIn(List<Integer> values) {
            addCriterion("income_id in", values, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotIn(List<Integer> values) {
            addCriterion("income_id not in", values, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdBetween(Integer value1, Integer value2) {
            addCriterion("income_id between", value1, value2, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("income_id not between", value1, value2, "incomeId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdIsNull() {
            addCriterion("income_user_id is null");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdIsNotNull() {
            addCriterion("income_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdEqualTo(Integer value) {
            addCriterion("income_user_id =", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdNotEqualTo(Integer value) {
            addCriterion("income_user_id <>", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdGreaterThan(Integer value) {
            addCriterion("income_user_id >", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_user_id >=", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdLessThan(Integer value) {
            addCriterion("income_user_id <", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("income_user_id <=", value, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdIn(List<Integer> values) {
            addCriterion("income_user_id in", values, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdNotIn(List<Integer> values) {
            addCriterion("income_user_id not in", values, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("income_user_id between", value1, value2, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("income_user_id not between", value1, value2, "incomeUserId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdIsNull() {
            addCriterion("income_item_id is null");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdIsNotNull() {
            addCriterion("income_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdEqualTo(Integer value) {
            addCriterion("income_item_id =", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdNotEqualTo(Integer value) {
            addCriterion("income_item_id <>", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdGreaterThan(Integer value) {
            addCriterion("income_item_id >", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_item_id >=", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdLessThan(Integer value) {
            addCriterion("income_item_id <", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("income_item_id <=", value, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdIn(List<Integer> values) {
            addCriterion("income_item_id in", values, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdNotIn(List<Integer> values) {
            addCriterion("income_item_id not in", values, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdBetween(Integer value1, Integer value2) {
            addCriterion("income_item_id between", value1, value2, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("income_item_id not between", value1, value2, "incomeItemId");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyIsNull() {
            addCriterion("income_money is null");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyIsNotNull() {
            addCriterion("income_money is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyEqualTo(Float value) {
            addCriterion("income_money =", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotEqualTo(Float value) {
            addCriterion("income_money <>", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyGreaterThan(Float value) {
            addCriterion("income_money >", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("income_money >=", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyLessThan(Float value) {
            addCriterion("income_money <", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyLessThanOrEqualTo(Float value) {
            addCriterion("income_money <=", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyIn(List<Float> values) {
            addCriterion("income_money in", values, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotIn(List<Float> values) {
            addCriterion("income_money not in", values, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyBetween(Float value1, Float value2) {
            addCriterion("income_money between", value1, value2, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotBetween(Float value1, Float value2) {
            addCriterion("income_money not between", value1, value2, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIsNull() {
            addCriterion("income_date is null");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIsNotNull() {
            addCriterion("income_date is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeDateEqualTo(Date value) {
            addCriterion("income_date =", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotEqualTo(Date value) {
            addCriterion("income_date <>", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateGreaterThan(Date value) {
            addCriterion("income_date >", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("income_date >=", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateLessThan(Date value) {
            addCriterion("income_date <", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateLessThanOrEqualTo(Date value) {
            addCriterion("income_date <=", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIn(List<Date> values) {
            addCriterion("income_date in", values, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotIn(List<Date> values) {
            addCriterion("income_date not in", values, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateBetween(Date value1, Date value2) {
            addCriterion("income_date between", value1, value2, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotBetween(Date value1, Date value2) {
            addCriterion("income_date not between", value1, value2, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkIsNull() {
            addCriterion("income_remark is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkIsNotNull() {
            addCriterion("income_remark is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkEqualTo(String value) {
            addCriterion("income_remark =", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkNotEqualTo(String value) {
            addCriterion("income_remark <>", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkGreaterThan(String value) {
            addCriterion("income_remark >", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("income_remark >=", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkLessThan(String value) {
            addCriterion("income_remark <", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkLessThanOrEqualTo(String value) {
            addCriterion("income_remark <=", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkLike(String value) {
            addCriterion("income_remark like", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkNotLike(String value) {
            addCriterion("income_remark not like", value, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkIn(List<String> values) {
            addCriterion("income_remark in", values, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkNotIn(List<String> values) {
            addCriterion("income_remark not in", values, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkBetween(String value1, String value2) {
            addCriterion("income_remark between", value1, value2, "incomeRemark");
            return (Criteria) this;
        }

        public Criteria andIncomeRemarkNotBetween(String value1, String value2) {
            addCriterion("income_remark not between", value1, value2, "incomeRemark");
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