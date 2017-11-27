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

import com.gqxie.common.email.mq.EmailMsgSender;
import com.gqxie.entity.User;
import com.gqxie.service.UserService;
import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.email.EmailUtil;
import com.gqxie.util.encrypt.AesUtil;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("emailMsgSender")
    EmailMsgSender emailMsgSender;

    private Logger logger = Logger.getLogger(UserController.class);

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public ModelAndView execute(@RequestParam String account, @RequestParam String password)
    {
        User user = userService.verify(account, password);
        String msg;
        String view;
        ModelAndView mav = new ModelAndView();
        if (null == user)
        {
            msg = "用户名或密码错误";
            view = "login";
        }
        else
        {
            logger.info("user " + user.getNickName() + " login success");
            msg = "登录成功，欢迎你：" + user.getNickName();
            view = "success";
            emailMsgSender.sendEmail("xieguoqiang@chezhibao.com", "测试主题test",
                    "用户" + user.getNickName() + "于" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + "登录系统.");
        }
        mav.setViewName(view);
        mav.getModel().put("msg", msg);
        return mav;
    }

    /**
     * 通过userID查询指定用户
     *
     * @param id
     * @return
     */
    @RequestMapping("getUserByID")
    @ResponseBody
    private Object getUserByID(@RequestParam Long id)
    {
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
