package com.gqxie.constants.email;

/**
 * @author Xie Guoqiang
 * @date 2017-12-04 11:02:45
 */
public enum EmailTypeEnum
{
    LOGIN(1, "登录"),
    VERIFYCODE(2, "验证码");
    private Integer code;
    private String  desc;

    EmailTypeEnum(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode()
    {
        return this.code;
    }

    public String getDesc()
    {
        return this.desc;
    }
}
