/**
 * Project Name:SpringLearnning
 * File Name:TestBean.java
 * Package Name:com.gqxie.bean
 * Date:2017年6月3日下午3:20:44
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 * 
 */
/**
 * Project Name:SpringLearnning
 * File Name:TestBean.java
 * Package Name:com.gqxie.bean
 * Date:2017年6月3日下午3:20:44
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 * 
 */

package com.gqxie.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:TestBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月3日 下午3:20:44 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: TestBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月3日 下午3:20:44 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 */
public class TestBean
{

    /**
     * main:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     * 
     * @author xie
     * @param args
     * @since JDK 1.6
     */
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        MessageBean mb = ac.getBean("msg", MessageBean.class);
        mb.show();
    }

}
