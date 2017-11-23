package com.gqxie.service;

import com.gqxie.entity.User;

import java.util.List;

/**
 * @author gqxie
 */
public interface UserService
{
    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 按id查询指定用户
     *
     * @param id id
     * @return
     */
    User getUserByID(Long id);

    /**
     * 根据用户名查询指定用户
     *
     * @param account 用户名
     * @return
     */
    User findByAccount(String account);

    /**
     * 登录校验
     *
     * @param account 用户名
     * @param pwd     密码
     * @return
     */
    User verify(String account, String pwd);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return
     */
    Integer addUser(User user);
}
