/**  
 * Project Name:Dev  
 * File Name:Cost.java  
 * Package Name:com.gqxie.entity  
 * Date:2017年6月24日上午9:22:40  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:Cost <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午9:22:40 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class Cost implements Serializable
{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * 
     * @since JDK 1.8
     */
    private static final long serialVersionUID = -4234567408364857889L;

    private Integer cost_id;
    private String name;
    private Long base_duration;
    private Double base_cost;
    private Double unit_cost;
    private String status;
    private String descr;
    private Date createtime;
    private Date starttime;
    private String cost_type;

    /**
     * cost_id.
     * 
     * @return the cost_id
     * @since JDK 1.8
     */
    public Integer getCost_id()
    {
        return cost_id;
    }

    /**
     * cost_id.
     * 
     * @param cost_id the cost_id to set
     * @since JDK 1.8
     */
    public void setCost_id(Integer cost_id)
    {
        this.cost_id = cost_id;
    }

    /**
     * name.
     * 
     * @return the name
     * @since JDK 1.8
     */
    public String getName()
    {
        return name;
    }

    /**
     * name.
     * 
     * @param name the name to set
     * @since JDK 1.8
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * base_duration.
     * 
     * @return the base_duration
     * @since JDK 1.8
     */
    public Long getBase_duration()
    {
        return base_duration;
    }

    /**
     * base_duration.
     * 
     * @param base_duration the base_duration to set
     * @since JDK 1.8
     */
    public void setBase_duration(Long base_duration)
    {
        this.base_duration = base_duration;
    }

    /**
     * base_cost.
     * 
     * @return the base_cost
     * @since JDK 1.8
     */
    public Double getBase_cost()
    {
        return base_cost;
    }

    /**
     * base_cost.
     * 
     * @param base_cost the base_cost to set
     * @since JDK 1.8
     */
    public void setBase_cost(Double base_cost)
    {
        this.base_cost = base_cost;
    }

    /**
     * unit_cost.
     * 
     * @return the unit_cost
     * @since JDK 1.8
     */
    public Double getUnit_cost()
    {
        return unit_cost;
    }

    /**
     * unit_cost.
     * 
     * @param unit_cost the unit_cost to set
     * @since JDK 1.8
     */
    public void setUnit_cost(Double unit_cost)
    {
        this.unit_cost = unit_cost;
    }

    /**
     * status.
     * 
     * @return the status
     * @since JDK 1.8
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * status.
     * 
     * @param status the status to set
     * @since JDK 1.8
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * descr.
     * 
     * @return the descr
     * @since JDK 1.8
     */
    public String getDescr()
    {
        return descr;
    }

    /**
     * descr.
     * 
     * @param descr the descr to set
     * @since JDK 1.8
     */
    public void setDescr(String descr)
    {
        this.descr = descr;
    }

    /**
     * createtime.
     * 
     * @return the createtime
     * @since JDK 1.8
     */
    public Date getCreatetime()
    {
        return createtime;
    }

    /**
     * createtime.
     * 
     * @param createtime the createtime to set
     * @since JDK 1.8
     */
    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    /**
     * starttime.
     * 
     * @return the starttime
     * @since JDK 1.8
     */
    public Date getStarttime()
    {
        return starttime;
    }

    /**
     * starttime.
     * 
     * @param starttime the starttime to set
     * @since JDK 1.8
     */
    public void setStarttime(Date starttime)
    {
        this.starttime = starttime;
    }

    /**
     * cost_type.
     * 
     * @return the cost_type
     * @since JDK 1.8
     */
    public String getCost_type()
    {
        return cost_type;
    }

    /**
     * cost_type.
     * 
     * @param cost_type the cost_type to set
     * @since JDK 1.8
     */
    public void setCost_type(String cost_type)
    {
        this.cost_type = cost_type;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Cost [cost_id=" + cost_id + ", name=" + name + ", base_duration=" + base_duration + ", base_cost="
                + base_cost + ", unit_cost=" + unit_cost + ", status=" + status + ", descr=" + descr + ", createtime="
                + createtime + ", starttime=" + starttime + ", cost_type=" + cost_type + "]";
    }

}
