/**  
 * Project Name:Dev  
 * File Name:ICostDao.java  
 * Package Name:com.gqxie.dao  
 * Date:2017年6月24日上午9:49:04  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.dao;

import java.util.List;

import com.gqxie.entity.Cost;

/**  
 * ClassName:ICostDao <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月24日 上午9:49:04 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public interface ICostDao
{

    /**
     * 
     * findAll:(这里用一句话描述这个方法的作用). <br/>  
     *  
     * @author xie  
     * @return  
     * @since JDK 1.8
     */
    List<Cost> findAll();

}
