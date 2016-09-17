package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.List;

public class PrivateItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrivateItemExample() {
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

        public Criteria andPrivateItemIdIsNull() {
            addCriterion("private_item_id is null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdIsNotNull() {
            addCriterion("private_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdEqualTo(Integer value) {
            addCriterion("private_item_id =", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdNotEqualTo(Integer value) {
            addCriterion("private_item_id <>", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdGreaterThan(Integer value) {
            addCriterion("private_item_id >", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("private_item_id >=", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdLessThan(Integer value) {
            addCriterion("private_item_id <", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("private_item_id <=", value, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdIn(List<Integer> values) {
            addCriterion("private_item_id in", values, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdNotIn(List<Integer> values) {
            addCriterion("private_item_id not in", values, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdBetween(Integer value1, Integer value2) {
            addCriterion("private_item_id between", value1, value2, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("private_item_id not between", value1, value2, "privateItemId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdIsNull() {
            addCriterion("private_item_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdIsNotNull() {
            addCriterion("private_item_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdEqualTo(Integer value) {
            addCriterion("private_item_user_id =", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdNotEqualTo(Integer value) {
            addCriterion("private_item_user_id <>", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdGreaterThan(Integer value) {
            addCriterion("private_item_user_id >", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("private_item_user_id >=", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdLessThan(Integer value) {
            addCriterion("private_item_user_id <", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("private_item_user_id <=", value, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdIn(List<Integer> values) {
            addCriterion("private_item_user_id in", values, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdNotIn(List<Integer> values) {
            addCriterion("private_item_user_id not in", values, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdBetween(Integer value1, Integer value2) {
            addCriterion("private_item_user_id between", value1, value2, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("private_item_user_id not between", value1, value2, "privateItemUserId");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameIsNull() {
            addCriterion("private_item_name is null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameIsNotNull() {
            addCriterion("private_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameEqualTo(String value) {
            addCriterion("private_item_name =", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameNotEqualTo(String value) {
            addCriterion("private_item_name <>", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameGreaterThan(String value) {
            addCriterion("private_item_name >", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("private_item_name >=", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameLessThan(String value) {
            addCriterion("private_item_name <", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameLessThanOrEqualTo(String value) {
            addCriterion("private_item_name <=", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameLike(String value) {
            addCriterion("private_item_name like", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameNotLike(String value) {
            addCriterion("private_item_name not like", value, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameIn(List<String> values) {
            addCriterion("private_item_name in", values, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameNotIn(List<String> values) {
            addCriterion("private_item_name not in", values, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameBetween(String value1, String value2) {
            addCriterion("private_item_name between", value1, value2, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemNameNotBetween(String value1, String value2) {
            addCriterion("private_item_name not between", value1, value2, "privateItemName");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExIsNull() {
            addCriterion("private_item_in_or_ex is null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExIsNotNull() {
            addCriterion("private_item_in_or_ex is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExEqualTo(String value) {
            addCriterion("private_item_in_or_ex =", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExNotEqualTo(String value) {
            addCriterion("private_item_in_or_ex <>", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExGreaterThan(String value) {
            addCriterion("private_item_in_or_ex >", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExGreaterThanOrEqualTo(String value) {
            addCriterion("private_item_in_or_ex >=", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExLessThan(String value) {
            addCriterion("private_item_in_or_ex <", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExLessThanOrEqualTo(String value) {
            addCriterion("private_item_in_or_ex <=", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExLike(String value) {
            addCriterion("private_item_in_or_ex like", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExNotLike(String value) {
            addCriterion("private_item_in_or_ex not like", value, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExIn(List<String> values) {
            addCriterion("private_item_in_or_ex in", values, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExNotIn(List<String> values) {
            addCriterion("private_item_in_or_ex not in", values, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExBetween(String value1, String value2) {
            addCriterion("private_item_in_or_ex between", value1, value2, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemInOrExNotBetween(String value1, String value2) {
            addCriterion("private_item_in_or_ex not between", value1, value2, "privateItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkIsNull() {
            addCriterion("private_item_remark is null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkIsNotNull() {
            addCriterion("private_item_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkEqualTo(String value) {
            addCriterion("private_item_remark =", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkNotEqualTo(String value) {
            addCriterion("private_item_remark <>", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkGreaterThan(String value) {
            addCriterion("private_item_remark >", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("private_item_remark >=", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkLessThan(String value) {
            addCriterion("private_item_remark <", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkLessThanOrEqualTo(String value) {
            addCriterion("private_item_remark <=", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkLike(String value) {
            addCriterion("private_item_remark like", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkNotLike(String value) {
            addCriterion("private_item_remark not like", value, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkIn(List<String> values) {
            addCriterion("private_item_remark in", values, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkNotIn(List<String> values) {
            addCriterion("private_item_remark not in", values, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkBetween(String value1, String value2) {
            addCriterion("private_item_remark between", value1, value2, "privateItemRemark");
            return (Criteria) this;
        }

        public Criteria andPrivateItemRemarkNotBetween(String value1, String value2) {
            addCriterion("private_item_remark not between", value1, value2, "privateItemRemark");
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