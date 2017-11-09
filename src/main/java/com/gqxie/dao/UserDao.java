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

public interface UserDao
{
    /**
     * 获取所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 按id查询指定用户
     * @param id    id
     * @return
     */
    User findByID(Long id);

    /**
     * 根据用户名查询指定用户
     * @param account   用户名
     * @return
     */
    User findByAccount(String account);

    /**
     * 登录校验
     * @param account   用户名
     * @param pwd   密码
     * @return
     */
    User verify(@Param("account") String account, @Param("pwd") String pwd);

    /**
     * 新增用户
     * @param user  用户
     * @return
     */
    Integer addUser(User user);
}
