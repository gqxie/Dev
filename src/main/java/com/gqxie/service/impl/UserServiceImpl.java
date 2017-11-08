package com.gqxie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gqxie.dao.UserDao;
import com.gqxie.entity.User;
import com.gqxie.service.UserService;

@Service
@Transactional
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
    public User getUserByID(Long id)
    {
        return userDao.findByID(id);
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
    
    @Override
    public Integer addUser(User user)
    {
        return userDao.addUser(user);
    }

}
