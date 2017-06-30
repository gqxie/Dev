/**  
 * Project Name:Dev  
 * File Name:TestEmpDao.java  
 * Package Name:com.gqxie.test  
 * Date:2017年6月24日上午8:51:43  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gqxie.dao.IUserDao;
import com.gqxie.entity.User;

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
public class TestUserDao
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        IUserDao userDao = ac.getBean("IUserDao", IUserDao.class);
        /*
         * List<User> list = userDao.findAll();
         * for (User user : list)
         * {
         * System.out.println(user);
         * }
         */
        User user = userDao.verify("abc@234.com", "123456");
        System.out.println(user);
    }
}
