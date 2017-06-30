/**  
 * Project Name:Dev  
 * File Name:EncryptTest.java  
 * Package Name:com.gqxie.test  
 * Date:2017年6月30日下午12:50:36  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.test;

import org.junit.Test;

import com.gqxie.util.encrypt.DESUtil;
import com.gqxie.util.encrypt.MD5Util;
import com.gqxie.util.encrypt.SHAUtil;
import com.gqxie.util.encrypt.ThreeDESUtil;

/**
 * ClassName:EncryptTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月30日 下午12:50:36 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
public class EncryptTest
{
    @Test
    public void desTest() throws Exception
    {
        String source = "amigoxie";
        System.out.println("原文: " + source);
        String key = "A1B2C3D4E5F60708";
        String encryptData = DESUtil.encrypt(source, key);
        System.out.println("加密后: " + encryptData);
        String decryptData = DESUtil.decrypt(encryptData, key);
        System.out.println("解密后: " + decryptData);
    }

    @Test
    public void md5Test() throws Exception
    {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("MD5后：" + MD5Util.md5Encode(str));
    }

    @Test
    public void threeDesTest() throws Exception
    {
        byte[] key = "6C4E60E55552386C759569836DC0F83869836DC0F838C0F7".getBytes();
        byte[] keyiv = { 1, 2, 3, 4, 5, 6, 7, 8 };
        byte[] data = "amigoxie".getBytes("UTF-8");
        System.out.println("data.length=" + data.length);
        System.out.println("CBC加密解密");
        byte[] str5 = ThreeDESUtil.des3EncodeCBC(key, keyiv, data);
        System.out.println(new sun.misc.BASE64Encoder().encode(str5));

        byte[] str6 = ThreeDESUtil.des3DecodeCBC(key, keyiv, str5);
        System.out.println(new String(str6, "UTF-8"));
    }

    @Test
    public void shaTest() throws Exception
    {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + SHAUtil.shaEncode(str));
    }
}
