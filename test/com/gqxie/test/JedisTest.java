/**  
 * Project Name:Dev  
 * File Name:JedisTest.java  
 * Package Name:com.gqxie.test  
 * Date:2017年6月30日下午1:35:59  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.test;
/**  
 * ClassName:JedisTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月30日 下午1:35:59 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */

import com.gqxie.util.redis.JedisUtil;

public class JedisTest
{
    public static void main(String[] args)
    {
        JedisUtil.set("key", 5);
        int a = JedisUtil.getInt("key");
        System.out.println(a);

    }
}
