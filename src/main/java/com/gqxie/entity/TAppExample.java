package com.gqxie.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAppExample
{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TAppExample()
    {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause()
    {
        return orderByClause;
    }

    public void setDistinct(boolean distinct)
    {
        this.distinct = distinct;
    }

    public boolean isDistinct()
    {
        return distinct;
    }

    public List<Criteria> getOredCriteria()
    {
        return oredCriteria;
    }

    public void or(Criteria criteria)
    {
        oredCriteria.add(criteria);
    }

    public Criteria or()
    {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria()
    {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0)
        {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal()
    {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear()
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }

    public Integer getLimit()
    {
        return limit;
    }

    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }

    public Integer getOffset()
    {
        return offset;
    }

    protected abstract static class GeneratedCriteria
    {
        protected List<Criterion> criteria;

        protected GeneratedCriteria()
        {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid()
        {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria()
        {
            return criteria;
        }

        public List<Criterion> getCriteria()
        {
            return criteria;
        }

        protected void addCriterion(String condition)
        {
            if (condition == null)
            {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property)
        {
            if (value == null)
            {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property)
        {
            if (value1 == null || value2 == null)
            {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull()
        {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull()
        {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value)
        {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value)
        {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value)
        {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value)
        {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value)
        {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value)
        {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values)
        {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values)
        {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2)
        {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2)
        {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNull()
        {
            addCriterion("appname is null");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNotNull()
        {
            addCriterion("appname is not null");
            return (Criteria) this;
        }

        public Criteria andAppnameEqualTo(String value)
        {
            addCriterion("appname =", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotEqualTo(String value)
        {
            addCriterion("appname <>", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThan(String value)
        {
            addCriterion("appname >", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThanOrEqualTo(String value)
        {
            addCriterion("appname >=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThan(String value)
        {
            addCriterion("appname <", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThanOrEqualTo(String value)
        {
            addCriterion("appname <=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLike(String value)
        {
            addCriterion("appname like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotLike(String value)
        {
            addCriterion("appname not like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameIn(List<String> values)
        {
            addCriterion("appname in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotIn(List<String> values)
        {
            addCriterion("appname not in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameBetween(String value1, String value2)
        {
            addCriterion("appname between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotBetween(String value1, String value2)
        {
            addCriterion("appname not between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull()
        {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull()
        {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value)
        {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value)
        {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value)
        {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value)
        {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value)
        {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value)
        {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value)
        {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value)
        {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values)
        {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values)
        {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2)
        {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2)
        {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull()
        {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull()
        {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value)
        {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value)
        {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value)
        {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value)
        {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value)
        {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value)
        {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values)
        {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values)
        {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2)
        {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2)
        {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull()
        {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull()
        {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value)
        {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value)
        {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value)
        {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value)
        {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value)
        {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value)
        {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values)
        {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values)
        {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2)
        {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2)
        {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria
    {

        protected Criteria()
        {
            super();
        }
    }

    public static class Criterion
    {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition()
        {
            return condition;
        }

        public Object getValue()
        {
            return value;
        }

        public Object getSecondValue()
        {
            return secondValue;
        }

        public boolean isNoValue()
        {
            return noValue;
        }

        public boolean isSingleValue()
        {
            return singleValue;
        }

        public boolean isBetweenValue()
        {
            return betweenValue;
        }

        public boolean isListValue()
        {
            return listValue;
        }

        public String getTypeHandler()
        {
            return typeHandler;
        }

        protected Criterion(String condition)
        {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>)
            {
                this.listValue = true;
            }
            else
            {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value)
        {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue)
        {
            this(condition, value, secondValue, null);
        }
    }
}