package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.List;

public class PublicItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublicItemExample() {
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

        public Criteria andPublicItemIdIsNull() {
            addCriterion("public_item_id is null");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdIsNotNull() {
            addCriterion("public_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdEqualTo(Integer value) {
            addCriterion("public_item_id =", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdNotEqualTo(Integer value) {
            addCriterion("public_item_id <>", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdGreaterThan(Integer value) {
            addCriterion("public_item_id >", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("public_item_id >=", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdLessThan(Integer value) {
            addCriterion("public_item_id <", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("public_item_id <=", value, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdIn(List<Integer> values) {
            addCriterion("public_item_id in", values, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdNotIn(List<Integer> values) {
            addCriterion("public_item_id not in", values, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdBetween(Integer value1, Integer value2) {
            addCriterion("public_item_id between", value1, value2, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("public_item_id not between", value1, value2, "publicItemId");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameIsNull() {
            addCriterion("public_item_name is null");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameIsNotNull() {
            addCriterion("public_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameEqualTo(String value) {
            addCriterion("public_item_name =", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameNotEqualTo(String value) {
            addCriterion("public_item_name <>", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameGreaterThan(String value) {
            addCriterion("public_item_name >", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("public_item_name >=", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameLessThan(String value) {
            addCriterion("public_item_name <", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameLessThanOrEqualTo(String value) {
            addCriterion("public_item_name <=", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameLike(String value) {
            addCriterion("public_item_name like", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameNotLike(String value) {
            addCriterion("public_item_name not like", value, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameIn(List<String> values) {
            addCriterion("public_item_name in", values, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameNotIn(List<String> values) {
            addCriterion("public_item_name not in", values, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameBetween(String value1, String value2) {
            addCriterion("public_item_name between", value1, value2, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemNameNotBetween(String value1, String value2) {
            addCriterion("public_item_name not between", value1, value2, "publicItemName");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExIsNull() {
            addCriterion("public_item_in_or_ex is null");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExIsNotNull() {
            addCriterion("public_item_in_or_ex is not null");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExEqualTo(String value) {
            addCriterion("public_item_in_or_ex =", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExNotEqualTo(String value) {
            addCriterion("public_item_in_or_ex <>", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExGreaterThan(String value) {
            addCriterion("public_item_in_or_ex >", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExGreaterThanOrEqualTo(String value) {
            addCriterion("public_item_in_or_ex >=", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExLessThan(String value) {
            addCriterion("public_item_in_or_ex <", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExLessThanOrEqualTo(String value) {
            addCriterion("public_item_in_or_ex <=", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExLike(String value) {
            addCriterion("public_item_in_or_ex like", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExNotLike(String value) {
            addCriterion("public_item_in_or_ex not like", value, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExIn(List<String> values) {
            addCriterion("public_item_in_or_ex in", values, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExNotIn(List<String> values) {
            addCriterion("public_item_in_or_ex not in", values, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExBetween(String value1, String value2) {
            addCriterion("public_item_in_or_ex between", value1, value2, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemInOrExNotBetween(String value1, String value2) {
            addCriterion("public_item_in_or_ex not between", value1, value2, "publicItemInOrEx");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkIsNull() {
            addCriterion("public_item_remark is null");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkIsNotNull() {
            addCriterion("public_item_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkEqualTo(String value) {
            addCriterion("public_item_remark =", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkNotEqualTo(String value) {
            addCriterion("public_item_remark <>", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkGreaterThan(String value) {
            addCriterion("public_item_remark >", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("public_item_remark >=", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkLessThan(String value) {
            addCriterion("public_item_remark <", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkLessThanOrEqualTo(String value) {
            addCriterion("public_item_remark <=", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkLike(String value) {
            addCriterion("public_item_remark like", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkNotLike(String value) {
            addCriterion("public_item_remark not like", value, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkIn(List<String> values) {
            addCriterion("public_item_remark in", values, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkNotIn(List<String> values) {
            addCriterion("public_item_remark not in", values, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkBetween(String value1, String value2) {
            addCriterion("public_item_remark between", value1, value2, "publicItemRemark");
            return (Criteria) this;
        }

        public Criteria andPublicItemRemarkNotBetween(String value1, String value2) {
            addCriterion("public_item_remark not between", value1, value2, "publicItemRemark");
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