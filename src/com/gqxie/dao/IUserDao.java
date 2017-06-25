/**  
 * Project Name:Dev  
 * File Name:IUserDao.java  
 * Package Name:com.gqxie.dao  
 * Date:2017年6月25日上午9:01:47  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.dao;
/**  
 * ClassName:IUserDao <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月25日 上午9:01:47 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gqxie.entity.User;

public interface IUserDao
{
    List<User> findAll();

    User findByUserID(Long userID);

    User findByAccount(String account);

    User verify(@Param("account")String account, @Param("pwd")String pwd);
}
