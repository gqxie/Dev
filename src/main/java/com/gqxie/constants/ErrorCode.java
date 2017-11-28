package com.gqxie.constants;

/**
 * @author Xie Guoqiang
 * @date 2017-11-28 13:55:08
 */
public enum ErrorCode
{
    RECORD_NOT_EXIST("9000101", "记录不存在"),

    ACCOUONT_OR_PASSWORD_ERROR("9000102", "用户名或密码错误");

    private String code;

    private String message;

    ErrorCode(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getMessage()
    {
        return message;
    }
}

