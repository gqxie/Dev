package com.gqxie.service;

import java.util.List;

import com.gqxie.entity.User;

public interface UserService
{
    List<User> findAll();

    User getUserByID(Long id);

    User findByAccount(String account);

    User verify(String account, String pwd);

    Integer addUser(User user);
}
