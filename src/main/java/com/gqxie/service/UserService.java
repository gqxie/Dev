package com.gqxie.service;

import java.util.List;

import com.gqxie.entity.User;

public interface UserService
{
    List<User> findAll();

    User findByUserID(Long userID);

    User findByAccount(String account);

    User verify(String account, String pwd);
}
