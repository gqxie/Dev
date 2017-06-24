/**  
 * Project Name:Dev  
 * File Name:EmpDao.java  
 * Package Name:com.gqxie.dao  
 * Date:2017年6月24日上午8:27:37  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gqxie.entity.Emp;
import com.gqxie.entity.EmpRowMapper;

/**
 * ClassName:EmpDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午8:27:37 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
@Repository
public class EmpDaoImpl
{
    @Resource
    private JdbcTemplate template;

    /**
     * 
     * save:(这里用一句话描述这个方法的作用). <br/>
     * 
     * @author xie
     * @param emp
     * @since JDK 1.8
     */
    public void save(Emp emp)
    {
        String sql = "insert into t_emp " + " (name,salary,age) values (?,?,?)";
        Object[] params = { emp.getName(), emp.getSalary(), emp.getAge() };
        template.update(sql, params);
    }

    /**
     * 
     * delete:(这里用一句话描述这个方法的作用). <br/>
     * 
     * @author xie
     * @param id
     * @since JDK 1.8
     */
    public void delete(int id)
    {
        String sql = "delete from t_emp " + " where id=?";
        Object[] params = { id };
        template.update(sql, params);
    }

    /**
     * 
     * findAll:(这里用一句话描述这个方法的作用). <br/>
     * 
     * @author xie
     * @return
     * @since JDK 1.8
     */
    public List<Emp> findAll()
    {
        String sql = "select * from t_emp";
        EmpRowMapper rowMapper = new EmpRowMapper();
        List<Emp> list = template.query(sql, rowMapper);
        return list;
    }

    /**
     * 
     * findById:(这里用一句话描述这个方法的作用). <br/>
     * 
     * @author xie
     * @param id
     * @return
     * @since JDK 1.8
     */
    public Emp findById(int id)
    {
        String sql = "select * from t_emp " + "where id=?";
        Object[] params = { id };
        EmpRowMapper rowMapper = new EmpRowMapper();
        Emp emp = template.queryForObject(sql, params, rowMapper);
        return emp;
    }
}
