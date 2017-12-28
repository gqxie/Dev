package com.gqxie.controller;
/**
 * @author xie
 * @since JDK 1.8
 */

import com.gqxie.constants.ErrorCode;
import com.gqxie.constants.user.UserStateEnum;
import com.gqxie.entity.Result;
import com.gqxie.entity.TUser;
import com.gqxie.service.UserService;
import com.gqxie.util.ehcache.EhcacheUtil;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RequestMapping("/user")
@Controller
@Validated
public class UserController
{
    @Autowired
    UserService userService;

    @Resource(name = "redisTemplate")
    ValueOperations valueOperations;

    /**
     * 用户登录
     *
     * @param account  用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam @NotBlank(message = "用户名不能为空") String account, @RequestParam String password)
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
    public Object register(TUser user, String verifyCode)
    {
        Result result = new Result();
        if (!CollectionUtils.isEmpty(userService.findByAccount(user.getAccount())))
        {
            result.fail(ErrorCode.RECORD_EXIST_ACCOUNT);
            return result;
        }
        if (!CollectionUtils.isEmpty(userService.findByEmail(user.getEmail())))
        {
            result.fail(ErrorCode.RECORD_EXIST_EMAIL);
            return result;
        }
        if (!verifyCode.equals(EhcacheUtil.getInstance().get(user.getAccount())))
        {
            result.fail(ErrorCode.VERIFY_CODE_ERROR);
            return result;
        }
        user.setState(UserStateEnum.INACTIVATED.getCode());
        userService.addUser(user);
        result.success();
        return result;
    }

    /**
     * 发送验证码
     *
     * @return
     */
    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public Object sendVerifyCode(String account, String email)
    {
        return userService.sendVerifyCode(account, email);
    }

    /**
     * aop测试
     *
     * @param id
     * @return
     */
    @RequestMapping("/findUserById")
    @ResponseBody
    public Object findUserById()
    {
        userService.findUserById(1);

        try
        {
            userService.findUserById(0);
        }
        catch (Exception e)
        {
        }

        return "hello";
    }

    @RequestMapping("/testRedis")
    @ResponseBody
    public Object testRedis()
    {
        valueOperations.set("a", "1", 5, TimeUnit.MINUTES);
        return valueOperations.get("a");
    }
}
