/**  
 * Project Name:Dev  
 * File Name:ThreeDESUtil.java  
 * Package Name:com.gqxie.util.encrypt  
 * Date:2017年6月30日下午12:33:36  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.util.encrypt;

/**  
 * ClassName:ThreeDESUtil <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月30日 下午12:33:36 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ThreeDesUtil
{
    /**
     * 算法名称
     */
    public static final String KEY_ALGORITHM    = "desede";
    /**
     * 算法名称/加密模式/填充方式
     */
    public static final String CIPHER_ALGORITHM = "desede/CBC/NoPadding";

    private static final char  A_LOWER_CASE     = 'a';

    private static final char  A_UPPER_CASE     = 'A';

    private static final char  ZERO             = '0';

    /**
     * CBC加密
     * 
     * @param key
     *            密钥
     * @param keyiv
     *            IV
     * @param data
     *            明文
     * @return Base64编码的密文
     * @throws Exception
     */
    public static byte[] des3EncodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception
    {
        Security.addProvider(new BouncyCastleProvider());
        Key deskey = keyGenerator(new String(key));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        for (int k = 0; k < bOut.length; k++)
        {
            System.out.print(bOut[k] + " ");
        }
        System.out.println("");
        return bOut;
    }

    /**
     * 
     * 生成密钥key对象
     * 
     * @param KeyStr
     *            密钥字符串
     * @return 密钥对象
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws Exception
     */
    private static Key keyGenerator(String keyStr) throws Exception
    {
        byte input[] = hexString2Bytes(keyStr);
        DESedeKeySpec keySpec = new DESedeKeySpec(input);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        return ((Key) (keyFactory.generateSecret(((java.security.spec.KeySpec) (keySpec)))));
    }

    private static int parse(char c)
    {
        if (c >= A_LOWER_CASE)
        {
            return (c - A_LOWER_CASE + 10) & 0x0f;
        }
        if (c >= A_UPPER_CASE)
        {
            return (c - A_UPPER_CASE + 10) & 0x0f;
        }
        return (c - ZERO) & 0x0f;
    }

    /**
     * 从十六进制字符串到字节数组转换
     * 
     * @param hexstr
     * @return
     */
    public static byte[] hexString2Bytes(String hexstr)
    {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++)
        {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    /**
     * CBC解密
     * 
     * @param key
     *            密钥
     * @param keyiv
     *            IV
     * @param data
     *            Base64编码的密文
     * @return 明文
     * @throws Exception
     */
    public static byte[] des3DecodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception
    {
        Key deskey = keyGenerator(new String(key));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        return bOut;
    }
}
