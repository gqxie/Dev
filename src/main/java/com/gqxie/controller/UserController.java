package com.gqxie.controller;
/**
 * @author xie
 * @since JDK 1.8
 */
import com.gqxie.constants.ErrorCode;
import com.gqxie.entity.Result;
import com.gqxie.entity.TUser;
import com.gqxie.service.UserService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
@Validated
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
    public Object register(TUser user)
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
        return null;
    }
}
