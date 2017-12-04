package com.gqxie.constants.user;

/**
 * @author Xie Guoqiang
 * @date 2017-12-04 09:50:07
 */
public enum UserStateEnum
{
    ACTIVATED(1, "已激活"),

    INACTIVATED(0, "未激活");

    private Integer code;

    private String desc;

    UserStateEnum(Integer code, String desc)
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
