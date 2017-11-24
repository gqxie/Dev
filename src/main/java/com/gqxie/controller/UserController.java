/**
 * Project Name:Dev
 * File Name:CostListController.java
 * Package Name:com.gqxie.controller
 * Date:2017年6月24日上午9:47:04
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.
 */

package com.gqxie.controller;
/**
 * ClassName:CostListController <br/>
 * Date:     2017年6月24日 上午9:47:04 <br/>
 *
 * @author xie
 * @version
 * @see
 * @since JDK 1.8
 */

import com.gqxie.entity.User;
import com.gqxie.service.UserService;
import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.encrypt.AesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(UserController.class);

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
    {
        logger.warn("login begin...");
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.verify(account, password);
        String msg = null == user ? "用户名或密码错误" : "登录成功，欢迎你：" + user.getNickName();
        ModelAndView mav = new ModelAndView();
        String view = null == user ? "login" : "success";
        mav.setViewName(view);
        mav.getModel().put("msg", msg);
        logger.warn("login end...");
        return mav;
    }

    /**
     * 通过userID查询指定用户
     *
     * @param request
     * @return
     */
    @RequestMapping("getUserByID")
    @ResponseBody
    private Object getUserByID(HttpServletRequest request)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        User user = EhcacheUtil.get(id);
        return null != user ? user : userService.getUserByID(id);
    }

    /**
     * 查询所有用户
     *
     * @param request
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    private Object findAll(HttpServletRequest request)
    {
        return userService.findAll();
    }

    @RequestMapping("addUser")
    @ResponseBody
    private Object addUser(HttpServletRequest request)
    {
        User user = new User();
        user.setAccount(String.valueOf(request.getParameter(User.Fields.account.name())));
        String pwd = String.valueOf(request.getParameter(User.Fields.pwd.name()));
        user.setPwd(AesUtil.encrypt(pwd));
        userService.addUser(user);
        return user.getId();
    }

}
