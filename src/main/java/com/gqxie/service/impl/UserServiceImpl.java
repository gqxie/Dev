package com.gqxie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gqxie.dao.UserDao;
import com.gqxie.entity.User;
import com.gqxie.service.UserService;

/**
 * 
 * @author gqxie
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
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
