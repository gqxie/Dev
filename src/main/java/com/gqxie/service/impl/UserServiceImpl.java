package com.gqxie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gqxie.dao.UserDao;
import com.gqxie.entity.User;
import com.gqxie.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll()
    {
        return userDao.findAll();
    }

    @Override
    public User findByUserID(Long userID)
    {
        return userDao.findByUserID(userID);
    }

    @Override
    public User findByAccount(String account)
    {
        return userDao.findByAccount(account);
    }

    @Override
    public User verify(String account, String pwd)
    {
        return userDao.verify(account, pwd);
    }

}
