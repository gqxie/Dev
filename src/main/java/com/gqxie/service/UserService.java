package com.gqxie.service;

import com.gqxie.entity.TUser;

import java.util.List;

/**
 * @author Xie Guoqiang
 * @date 2017-11-28 17:05:41
 */
public interface UserService
{
    /**
     * 登录
     *
     * @param account  用户名
     * @param password 密码
     * @return
     */
    Object login(String account, String password);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Object getUserByID(Integer id);

    /**
     * 根据帐号查找
     *
     * @return
     */
    List<TUser> findByAccount(String account);

    /**
     * 根据邮箱查找
     *
     * @return
     */
    List<TUser> findByEmail(String email);
}
