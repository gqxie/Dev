/**  
 * Project Name:Dev  
 * File Name:TestEmpDao.java  
 * Package Name:com.gqxie.test  
 * Date:2017年6月24日上午8:51:43  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gqxie.dao.impl.EmpDaoImpl;
import com.gqxie.entity.Emp;

/**
 * ClassName:TestEmpDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月24日 上午8:51:43 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestEmpDao
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        EmpDaoImpl empDao = ac.getBean("empDao", EmpDaoImpl.class);
        /*
         * Emp emp = new Emp();
         * emp.setName("spring");
         * emp.setSalary(15000.0);
         * emp.setAge(20);
         * empDao.save(emp);
         */
        List<Emp> list = empDao.findAll();
        for (Emp emp : list)
        {
            System.out.println(emp);
        }
    }
}
