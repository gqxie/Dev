/**  
 * Project Name:Dev  
 * File Name:CostRowMapper.java  
 * Package Name:com.gqxie.entity  
 * Date:2017年6月24日上午9:30:18  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * ClassName:CostRowMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午9:30:18 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class CostRowMapper implements RowMapper<Cost>
{

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Cost mapRow(ResultSet rs, int index) throws SQLException
    {
        Cost cost = new Cost();
        cost.setCost_id(rs.getInt("cost_id"));
        cost.setName(rs.getString("name"));
        cost.setBase_duration(rs.getLong("base_duration"));
        cost.setBase_cost(rs.getDouble("base_cost"));
        cost.setUnit_cost(rs.getDouble("unit_cost"));
        cost.setDescr(rs.getString("descr"));
        cost.setStatus(rs.getString("status"));
        cost.setCreatetime(rs.getDate("createtime"));
        cost.setStarttime(rs.getDate("starttime"));
        cost.setCost_type(rs.getString("cost_type"));
        return cost;
    }

}
