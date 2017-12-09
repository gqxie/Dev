package com.gqxie.service.impl;

import com.gqxie.common.email.mq.EmailMsgSender;
import com.gqxie.common.email.vo.EmailVO;
import com.gqxie.constants.ErrorCode;
import com.gqxie.constants.email.EmailTypeEnum;
import com.gqxie.constants.user.UserStateEnum;
import com.gqxie.entity.Result;
import com.gqxie.entity.TUser;
import com.gqxie.entity.TUserExample;
import com.gqxie.mapper.TUserMapper;
import com.gqxie.service.UserService;
import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.math.RandomUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Xie Guoqiang
 * @date 2017-11-28 17:06:14
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    TUserMapper userMapper;

    @Autowired
    @Qualifier("emailMsgSender")
    EmailMsgSender emailMsgSender;

    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public Object login(String account, String password)
    {
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPwdEqualTo(password);
        List<TUser> userList = userMapper.selectByExample(userExample);
        Result result = new Result();
        if (CollectionUtils.isEmpty(userList))
        {
            result.fail(ErrorCode.ACCOUONT_OR_PASSWORD_ERROR);
            return result;
        }
        else if (UserStateEnum.INACTIVATED.getCode().equals(userList.get(0).getState()))
        {
            result.fail(ErrorCode.ACCOUNT_INACTIVATED);
            return result;
        }
        else
        {
            logger.info("user " + userList.get(0).getNickname() + " login success");
            result.setMessage("登录成功，欢迎你：" + userList.get(0).getNickname());
            return result;
        }
    }

    @Override
    public Object getUserByID(Integer id)
    {
        Result<List<TUser>> result = new Result<>();
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TUser> userList = userMapper.selectByExample(userExample);
        result.setTarget(userList);
        return result;
    }

    @Override
    public List<TUser> findByAccount(String account)
    {
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<TUser> findByEmail(String email)
    {
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void addUser(TUser user)
    {
        userMapper.insert(user);
    }

    @Override
    public Object sendVerifyCode(String account, String email)
    {
        Result result = new Result();
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(email))
        {
            result.fail();
            result.setMessage("用户名或邮箱为空");
            return result;
        }
        String verifyCode = RandomUtil.getRandomNum(6);
        EhcacheUtil.getInstance().put(account, verifyCode);
        EmailVO emailVO = new EmailVO(EmailTypeEnum.VERIFYCODE, email, "帐号注册验证码", "您的验证码是：" + verifyCode);
        emailMsgSender.sendEmail(emailVO);
        result.success();
        return result;
    }
}
