package com.gqxie.util.encrypt;

import java.security.Key;

import org.apache.log4j.Logger;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
/**
 * 
 * @author gqxie
 *
 */
public final class AesUtil
{

    private static Logger           logger = Logger.getLogger(AesUtil.class);

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

    public static String decrypt(String encryText)
    {
        String source = encryText;
        try
        {
            source = new String(aesCipherService.decrypt(Hex.decode(encryText), key.getEncoded()).getBytes());
        }
        catch (Exception e)
        {
            logger.error("decrypt text error...");
        }

        return source;
    }

    public static Key getKey()
    {
        return key;
    }

    public static void setKey(Key key)
    {
        AesUtil.key = key;
    }

    private AesUtil()
    {

    }

}
