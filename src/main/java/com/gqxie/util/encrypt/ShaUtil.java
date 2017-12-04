/**
 * Project Name:Dev
 * File Name:SHAUtil.java
 * Package Name:com.gqxie.util.encrypt
 * Date:2017年6月30日下午12:36:21
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.
 */

package com.gqxie.util.encrypt;

/**
 * ClassName:SHAUtil <br/>
 * Date:     2017年6月30日 下午12:36:21 <br/>
 *
 * @author xie
 * @version
 * @see
 * @since JDK 1.8
 */

import org.apache.log4j.Logger;

import java.security.MessageDigest;

public final class ShaUtil
{
    private static Logger logger = Logger.getLogger(ShaUtil.class);

    private ShaUtil()
    {

    }

    /***
     * SHA加密 生成40位SHA码
     *
     * @param inStr 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception
    {
        MessageDigest sha = null;
        try
        {
            sha = MessageDigest.getInstance("SHA");
        }
        catch (Exception e)
        {
            logger.error("sha encode error.", e);
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
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
