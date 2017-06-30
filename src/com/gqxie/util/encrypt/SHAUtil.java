/**  
 * Project Name:Dev  
 * File Name:SHAUtil.java  
 * Package Name:com.gqxie.util.encrypt  
 * Date:2017年6月30日下午12:36:21  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.util.encrypt;

/**  
 * ClassName:SHAUtil <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月30日 下午12:36:21 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
import java.security.MessageDigest;

public class SHAUtil
{
    /***
     * SHA加密 生成40位SHA码
     * 
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception
    {
        MessageDigest sha = null;
        try
        {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
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
