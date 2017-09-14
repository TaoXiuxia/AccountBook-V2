package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.List;

public class PayMethodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayMethodExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExIsNull() {
            addCriterion("is_count_in_this_month_ex is null");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExIsNotNull() {
            addCriterion("is_count_in_this_month_ex is not null");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExEqualTo(Integer value) {
            addCriterion("is_count_in_this_month_ex =", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExNotEqualTo(Integer value) {
            addCriterion("is_count_in_this_month_ex <>", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExGreaterThan(Integer value) {
            addCriterion("is_count_in_this_month_ex >", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_count_in_this_month_ex >=", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExLessThan(Integer value) {
            addCriterion("is_count_in_this_month_ex <", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExLessThanOrEqualTo(Integer value) {
            addCriterion("is_count_in_this_month_ex <=", value, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExIn(List<Integer> values) {
            addCriterion("is_count_in_this_month_ex in", values, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExNotIn(List<Integer> values) {
            addCriterion("is_count_in_this_month_ex not in", values, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExBetween(Integer value1, Integer value2) {
            addCriterion("is_count_in_this_month_ex between", value1, value2, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andIsCountInThisMonthExNotBetween(Integer value1, Integer value2) {
            addCriterion("is_count_in_this_month_ex not between", value1, value2, "isCountInThisMonthEx");
            return (Criteria) this;
        }

        public Criteria andInOrExIsNull() {
            addCriterion("in_or_ex is null");
            return (Criteria) this;
        }

        public Criteria andInOrExIsNotNull() {
            addCriterion("in_or_ex is not null");
            return (Criteria) this;
        }

        public Criteria andInOrExEqualTo(String value) {
            addCriterion("in_or_ex =", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExNotEqualTo(String value) {
            addCriterion("in_or_ex <>", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExGreaterThan(String value) {
            addCriterion("in_or_ex >", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExGreaterThanOrEqualTo(String value) {
            addCriterion("in_or_ex >=", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExLessThan(String value) {
            addCriterion("in_or_ex <", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExLessThanOrEqualTo(String value) {
            addCriterion("in_or_ex <=", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExLike(String value) {
            addCriterion("in_or_ex like", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExNotLike(String value) {
            addCriterion("in_or_ex not like", value, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExIn(List<String> values) {
            addCriterion("in_or_ex in", values, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExNotIn(List<String> values) {
            addCriterion("in_or_ex not in", values, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExBetween(String value1, String value2) {
            addCriterion("in_or_ex between", value1, value2, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andInOrExNotBetween(String value1, String value2) {
            addCriterion("in_or_ex not between", value1, value2, "inOrEx");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDeleIsNull() {
            addCriterion("dele is null");
            return (Criteria) this;
        }

        public Criteria andDeleIsNotNull() {
            addCriterion("dele is not null");
            return (Criteria) this;
        }

        public Criteria andDeleEqualTo(Integer value) {
            addCriterion("dele =", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleNotEqualTo(Integer value) {
            addCriterion("dele <>", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleGreaterThan(Integer value) {
            addCriterion("dele >", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleGreaterThanOrEqualTo(Integer value) {
            addCriterion("dele >=", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleLessThan(Integer value) {
            addCriterion("dele <", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleLessThanOrEqualTo(Integer value) {
            addCriterion("dele <=", value, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleIn(List<Integer> values) {
            addCriterion("dele in", values, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleNotIn(List<Integer> values) {
            addCriterion("dele not in", values, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleBetween(Integer value1, Integer value2) {
            addCriterion("dele between", value1, value2, "dele");
            return (Criteria) this;
        }

        public Criteria andDeleNotBetween(Integer value1, Integer value2) {
            addCriterion("dele not between", value1, value2, "dele");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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