package com.gqxie.controller;
/**
 * @author xie
 * @since JDK 1.8
 */

import com.gqxie.entity.TUser;
import com.gqxie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController
{
    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @param account  用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String account, @RequestParam String password)
    {
        return userService.login(account, password);
    }

    @RequestMapping("/getUserByID")
    @ResponseBody
    public Object getUserByID(@RequestParam Integer id)
    {

        return userService.getUserByID(id);
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object register(TUser user)
    {
        return null;
    }
}
