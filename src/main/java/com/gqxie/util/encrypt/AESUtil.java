package com.gqxie.util.encrypt;

import java.security.Key;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;

public class AESUtil
{

    private static Key              key;

    private static AesCipherService aesCipherService;

    static
    {
        aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);
    }

    public static String encrypt(String text)
    {
        return aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
    }

    public static String decrypt(String encText)
    {
        return new String(aesCipherService.decrypt(Hex.decode(encText), key.getEncoded()).getBytes());
    }

    public static Key getKey()
    {
        return key;
    }

    public static void setKey(Key key)
    {
        AESUtil.key = key;
    }

}
