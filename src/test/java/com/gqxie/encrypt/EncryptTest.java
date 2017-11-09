package com.gqxie.encrypt;

import java.security.Key;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Test;

public class EncryptTest
{

    @Test
    public void main(String[] args) throws Exception
    {
        // TODO Auto-generated method stub
        /*String account = "xie";
        String md5 = MD5Util.md5Encode(account);
        System.out.println("md5 : " + md5);
        String desEncrypt = DESUtil.encrypt("123", md5);
        System.out.println("desEncrypt : " + desEncrypt);
        String desDecrypt = DESUtil.decrypt(desEncrypt, md5);
        System.out.println("desDecrypt : " + desDecrypt);*/
        AesCipherService aesCipherService = new AesCipherService();  
        aesCipherService.setKeySize(128); //设置key长度  
        Key key = aesCipherService.generateNewKey();  
        String text = "helloworld";  
        //加密  
        String encText =  
        aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();  
        System.out.println("encText:"+encText);  
        //解密  
        String decText =  
        new String(aesCipherService.decrypt(Hex.decode(encText), key.getEncoded()).getBytes());  
        System.out.println("decText:"+decText);  
        
    }

}
