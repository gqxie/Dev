package com.gqxie.service;

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
}
