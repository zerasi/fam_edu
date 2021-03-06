package com.zerasi.entity;

import java.util.ArrayList;
import java.util.List;

public class UserCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCourseExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2020-05-05
     */
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCour_idIsNull() {
            addCriterion("cour_id is null");
            return (Criteria) this;
        }

        public Criteria andCour_idIsNotNull() {
            addCriterion("cour_id is not null");
            return (Criteria) this;
        }

        public Criteria andCour_idEqualTo(Integer value) {
            addCriterion("cour_id =", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idNotEqualTo(Integer value) {
            addCriterion("cour_id <>", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idGreaterThan(Integer value) {
            addCriterion("cour_id >", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("cour_id >=", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idLessThan(Integer value) {
            addCriterion("cour_id <", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idLessThanOrEqualTo(Integer value) {
            addCriterion("cour_id <=", value, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idIn(List<Integer> values) {
            addCriterion("cour_id in", values, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idNotIn(List<Integer> values) {
            addCriterion("cour_id not in", values, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idBetween(Integer value1, Integer value2) {
            addCriterion("cour_id between", value1, value2, "cour_id");
            return (Criteria) this;
        }

        public Criteria andCour_idNotBetween(Integer value1, Integer value2) {
            addCriterion("cour_id not between", value1, value2, "cour_id");
            return (Criteria) this;
        }

        public Criteria andStart_dateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStart_dateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStart_dateEqualTo(String value) {
            addCriterion("start_date =", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateNotEqualTo(String value) {
            addCriterion("start_date <>", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateGreaterThan(String value) {
            addCriterion("start_date >", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateGreaterThanOrEqualTo(String value) {
            addCriterion("start_date >=", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateLessThan(String value) {
            addCriterion("start_date <", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateLessThanOrEqualTo(String value) {
            addCriterion("start_date <=", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateLike(String value) {
            addCriterion("start_date like", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateNotLike(String value) {
            addCriterion("start_date not like", value, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateIn(List<String> values) {
            addCriterion("start_date in", values, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateNotIn(List<String> values) {
            addCriterion("start_date not in", values, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateBetween(String value1, String value2) {
            addCriterion("start_date between", value1, value2, "start_date");
            return (Criteria) this;
        }

        public Criteria andStart_dateNotBetween(String value1, String value2) {
            addCriterion("start_date not between", value1, value2, "start_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEnd_dateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_dateEqualTo(String value) {
            addCriterion("end_date =", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateNotEqualTo(String value) {
            addCriterion("end_date <>", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateGreaterThan(String value) {
            addCriterion("end_date >", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateGreaterThanOrEqualTo(String value) {
            addCriterion("end_date >=", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateLessThan(String value) {
            addCriterion("end_date <", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateLessThanOrEqualTo(String value) {
            addCriterion("end_date <=", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateLike(String value) {
            addCriterion("end_date like", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateNotLike(String value) {
            addCriterion("end_date not like", value, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateIn(List<String> values) {
            addCriterion("end_date in", values, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateNotIn(List<String> values) {
            addCriterion("end_date not in", values, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateBetween(String value1, String value2) {
            addCriterion("end_date between", value1, value2, "end_date");
            return (Criteria) this;
        }

        public Criteria andEnd_dateNotBetween(String value1, String value2) {
            addCriterion("end_date not between", value1, value2, "end_date");
            return (Criteria) this;
        }

        public Criteria andAdrssIsNull() {
            addCriterion("adrss is null");
            return (Criteria) this;
        }

        public Criteria andAdrssIsNotNull() {
            addCriterion("adrss is not null");
            return (Criteria) this;
        }

        public Criteria andAdrssEqualTo(String value) {
            addCriterion("adrss =", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssNotEqualTo(String value) {
            addCriterion("adrss <>", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssGreaterThan(String value) {
            addCriterion("adrss >", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssGreaterThanOrEqualTo(String value) {
            addCriterion("adrss >=", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssLessThan(String value) {
            addCriterion("adrss <", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssLessThanOrEqualTo(String value) {
            addCriterion("adrss <=", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssLike(String value) {
            addCriterion("adrss like", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssNotLike(String value) {
            addCriterion("adrss not like", value, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssIn(List<String> values) {
            addCriterion("adrss in", values, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssNotIn(List<String> values) {
            addCriterion("adrss not in", values, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssBetween(String value1, String value2) {
            addCriterion("adrss between", value1, value2, "adrss");
            return (Criteria) this;
        }

        public Criteria andAdrssNotBetween(String value1, String value2) {
            addCriterion("adrss not between", value1, value2, "adrss");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrIsNull() {
            addCriterion("acc_nbr is null");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrIsNotNull() {
            addCriterion("acc_nbr is not null");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrEqualTo(String value) {
            addCriterion("acc_nbr =", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrNotEqualTo(String value) {
            addCriterion("acc_nbr <>", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrGreaterThan(String value) {
            addCriterion("acc_nbr >", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrGreaterThanOrEqualTo(String value) {
            addCriterion("acc_nbr >=", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrLessThan(String value) {
            addCriterion("acc_nbr <", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrLessThanOrEqualTo(String value) {
            addCriterion("acc_nbr <=", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrLike(String value) {
            addCriterion("acc_nbr like", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrNotLike(String value) {
            addCriterion("acc_nbr not like", value, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrIn(List<String> values) {
            addCriterion("acc_nbr in", values, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrNotIn(List<String> values) {
            addCriterion("acc_nbr not in", values, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrBetween(String value1, String value2) {
            addCriterion("acc_nbr between", value1, value2, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andAcc_nbrNotBetween(String value1, String value2) {
            addCriterion("acc_nbr not between", value1, value2, "acc_nbr");
            return (Criteria) this;
        }

        public Criteria andStatus_cdIsNull() {
            addCriterion("status_cd is null");
            return (Criteria) this;
        }

        public Criteria andStatus_cdIsNotNull() {
            addCriterion("status_cd is not null");
            return (Criteria) this;
        }

        public Criteria andStatus_cdEqualTo(String value) {
            addCriterion("status_cd =", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdNotEqualTo(String value) {
            addCriterion("status_cd <>", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdGreaterThan(String value) {
            addCriterion("status_cd >", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdGreaterThanOrEqualTo(String value) {
            addCriterion("status_cd >=", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdLessThan(String value) {
            addCriterion("status_cd <", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdLessThanOrEqualTo(String value) {
            addCriterion("status_cd <=", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdLike(String value) {
            addCriterion("status_cd like", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdNotLike(String value) {
            addCriterion("status_cd not like", value, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdIn(List<String> values) {
            addCriterion("status_cd in", values, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdNotIn(List<String> values) {
            addCriterion("status_cd not in", values, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdBetween(String value1, String value2) {
            addCriterion("status_cd between", value1, value2, "status_cd");
            return (Criteria) this;
        }

        public Criteria andStatus_cdNotBetween(String value1, String value2) {
            addCriterion("status_cd not between", value1, value2, "status_cd");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak3IsNull() {
            addCriterion("bak3 is null");
            return (Criteria) this;
        }

        public Criteria andBak3IsNotNull() {
            addCriterion("bak3 is not null");
            return (Criteria) this;
        }

        public Criteria andBak3EqualTo(String value) {
            addCriterion("bak3 =", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotEqualTo(String value) {
            addCriterion("bak3 <>", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThan(String value) {
            addCriterion("bak3 >", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThanOrEqualTo(String value) {
            addCriterion("bak3 >=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThan(String value) {
            addCriterion("bak3 <", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThanOrEqualTo(String value) {
            addCriterion("bak3 <=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Like(String value) {
            addCriterion("bak3 like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotLike(String value) {
            addCriterion("bak3 not like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3In(List<String> values) {
            addCriterion("bak3 in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotIn(List<String> values) {
            addCriterion("bak3 not in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Between(String value1, String value2) {
            addCriterion("bak3 between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotBetween(String value1, String value2) {
            addCriterion("bak3 not between", value1, value2, "bak3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2020-05-05
     */
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