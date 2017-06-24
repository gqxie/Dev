/**  
 * Project Name:Dev  
 * File Name:TestCostDao.java  
 * Package Name:com.gqxie.test  
 * Date:2017年6月24日上午9:40:06  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gqxie.dao.ICostDao;
import com.gqxie.dao.impl.CostDaoImpl;
import com.gqxie.entity.Cost;

/**
 * ClassName:TestCostDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午9:40:06 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestCostDao
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        ICostDao costDao = ac.getBean("costDao", CostDaoImpl.class);
        List<Cost> list = costDao.findAll();
        for (Cost cost : list)
        {
            System.out.println(cost);
        }
    }
}
