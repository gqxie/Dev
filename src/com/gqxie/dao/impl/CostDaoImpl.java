/**  
 * Project Name:Dev  
 * File Name:CostDao.java  
 * Package Name:com.gqxie.dao  
 * Date:2017年6月24日上午9:28:50  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.dao.impl;
/**  
 * ClassName:CostDao <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月24日 上午9:28:50 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gqxie.dao.ICostDao;
import com.gqxie.entity.Cost;
import com.gqxie.entity.CostRowMapper;

@Repository
public class CostDaoImpl implements ICostDao
{
    @Resource
    private JdbcTemplate template;

    /**  
     * TODO 简单描述该方法的实现功能（可选）.  
     * @see com.gqxie.dao.ICostDao#findAll()  
     */
    @Override
    public List<Cost> findAll()
    {
        String sql = "select * from t_cost";
        CostRowMapper rowMapper = new CostRowMapper();
        List<Cost> list = template.query(sql, rowMapper);
        return list;
    }
}
