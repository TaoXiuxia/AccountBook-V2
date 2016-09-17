package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIsNull() {
            addCriterion("user_remark is null");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIsNotNull() {
            addCriterion("user_remark is not null");
            return (Criteria) this;
        }

        public Criteria andUserRemarkEqualTo(String value) {
            addCriterion("user_remark =", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotEqualTo(String value) {
            addCriterion("user_remark <>", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkGreaterThan(String value) {
            addCriterion("user_remark >", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("user_remark >=", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLessThan(String value) {
            addCriterion("user_remark <", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLessThanOrEqualTo(String value) {
            addCriterion("user_remark <=", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLike(String value) {
            addCriterion("user_remark like", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotLike(String value) {
            addCriterion("user_remark not like", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIn(List<String> values) {
            addCriterion("user_remark in", values, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotIn(List<String> values) {
            addCriterion("user_remark not in", values, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkBetween(String value1, String value2) {
            addCriterion("user_remark between", value1, value2, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotBetween(String value1, String value2) {
            addCriterion("user_remark not between", value1, value2, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNull() {
            addCriterion("user_register_time is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNotNull() {
            addCriterion("user_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeEqualTo(Date value) {
            addCriterion("user_register_time =", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotEqualTo(Date value) {
            addCriterion("user_register_time <>", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThan(Date value) {
            addCriterion("user_register_time >", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_register_time >=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThan(Date value) {
            addCriterion("user_register_time <", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_register_time <=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIn(List<Date> values) {
            addCriterion("user_register_time in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotIn(List<Date> values) {
            addCriterion("user_register_time not in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("user_register_time between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_register_time not between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeIsNull() {
            addCriterion("user_last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeIsNotNull() {
            addCriterion("user_last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeEqualTo(Date value) {
            addCriterion("user_last_login_time =", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeNotEqualTo(Date value) {
            addCriterion("user_last_login_time <>", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeGreaterThan(Date value) {
            addCriterion("user_last_login_time >", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_last_login_time >=", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeLessThan(Date value) {
            addCriterion("user_last_login_time <", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_last_login_time <=", value, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeIn(List<Date> values) {
            addCriterion("user_last_login_time in", values, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeNotIn(List<Date> values) {
            addCriterion("user_last_login_time not in", values, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("user_last_login_time between", value1, value2, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_last_login_time not between", value1, value2, "userLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeIsNull() {
            addCriterion("user_activation_code is null");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeIsNotNull() {
            addCriterion("user_activation_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeEqualTo(String value) {
            addCriterion("user_activation_code =", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeNotEqualTo(String value) {
            addCriterion("user_activation_code <>", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeGreaterThan(String value) {
            addCriterion("user_activation_code >", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_activation_code >=", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeLessThan(String value) {
            addCriterion("user_activation_code <", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeLessThanOrEqualTo(String value) {
            addCriterion("user_activation_code <=", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeLike(String value) {
            addCriterion("user_activation_code like", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeNotLike(String value) {
            addCriterion("user_activation_code not like", value, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeIn(List<String> values) {
            addCriterion("user_activation_code in", values, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeNotIn(List<String> values) {
            addCriterion("user_activation_code not in", values, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeBetween(String value1, String value2) {
            addCriterion("user_activation_code between", value1, value2, "userActivationCode");
            return (Criteria) this;
        }

        public Criteria andUserActivationCodeNotBetween(String value1, String value2) {
            addCriterion("user_activation_code not between", value1, value2, "userActivationCode");
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