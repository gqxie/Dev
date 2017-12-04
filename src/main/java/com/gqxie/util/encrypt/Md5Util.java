/**
 * Project Name:Dev
 * File Name:MD5Util.java
 * Package Name:com.gqxie.util.encrypt
 * Date:2017年6月30日下午12:35:51
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.
 */

package com.gqxie.util.encrypt;

/**
 * ClassName:MD5Util <br/>
 * Date:     2017年6月30日 下午12:35:51 <br/>
 *
 * @author xie
 * @version
 * @see
 * @since JDK 1.8
 */

import org.apache.log4j.Logger;

import java.security.MessageDigest;

public final class Md5Util
{

    private static Logger logger = Logger.getLogger(Md5Util.class);

    private Md5Util()
    {

    }

    /***
     * MD5加密 生成32位md5码
     *
     * @param inStr 待加密字符串
     * @return 返回32位md5码
     */
    public static String md5Encode(String inStr) throws Exception
    {
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (Exception e)
        {
            logger.error("encode error.", e);
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++)
        {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
            {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
