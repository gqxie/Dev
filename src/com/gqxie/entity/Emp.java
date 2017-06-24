/**  
 * Project Name:Dev  
 * File Name:Emp.java  
 * Package Name:com.gqxie.entity  
 * Date:2017年6月24日上午8:19:05  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.entity;

import java.io.Serializable;

/**
 * ClassName:Emp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午8:19:05 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class Emp implements Serializable
{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * 
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 2986844240165782766L;

    private Integer id;

    private String name;

    private Double salary;

    private Integer age;

    /**
     * id.
     * 
     * @return the id
     * @since JDK 1.8
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * id.
     * 
     * @param id the id to set
     * @since JDK 1.8
     */
    public void setId(Integer id)
    {
        this.id = id;
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
     * salary.
     * 
     * @return the salary
     * @since JDK 1.8
     */
    public Double getSalary()
    {
        return salary;
    }

    /**
     * salary.
     * 
     * @param salary the salary to set
     * @since JDK 1.8
     */
    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    /**
     * age.
     * 
     * @return the age
     * @since JDK 1.8
     */
    public Integer getAge()
    {
        return age;
    }

    /**
     * age.
     * 
     * @param age the age to set
     * @since JDK 1.8
     */
    public void setAge(Integer age)
    {
        this.age = age;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }

}
