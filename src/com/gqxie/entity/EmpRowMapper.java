/**  
 * Project Name:Dev  
 * File Name:EmpRowMapper.java  
 * Package Name:com.gqxie.entity  
 * Date:2017年6月24日上午9:09:16  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * ClassName:EmpRowMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午9:09:16 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class EmpRowMapper implements RowMapper<Emp>
{

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Emp mapRow(ResultSet rs, int index) throws SQLException
    {
        Emp emp = new Emp();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setAge(rs.getInt("age"));
        return emp;
    }

}
