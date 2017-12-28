package com.gqxie.fileserver;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 七牛云文件上传测试类
 *
 * @author Xie Guoqiang
 * @date 2017-12-07 13:31:26
 */
public class QiNiuTest
{

    /*@Test
    public void uploadTest()
    {
        String accessKey = "wq1KPgwnRPFcXJCtPSaE6MbMKG3kkcCWd8JGVjoe";
        String secretKey = "Y2ten8rYYYZfkvETBGSzB_pkVNLON0amvT-IkOel";
        String bucket = "xieguoqiang";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String localFilePath = "D:\\pictures\\logo.png";
        String key = null;

        try
        {
            Response response = uploadManager.put(localFilePath, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        }
        catch (QiniuException e)
        {
            Response r = e.response;
            System.out.println(r.toString());
            e.printStackTrace();
        }
    }*/

    @Test
    public void downLoad() throws UnsupportedEncodingException
    {
        String fileName = "Fv_HR2uA-LA1ahwqM6v1P6LSgDPP";
        String domainOfBucket = "oxhq7nx9p.bkt.clouddn.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);

        /*String fileName = "logo.png";
        String domainOfBucket = "oxhq7nx9p.bkt.clouddn.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "wq1KPgwnRPFcXJCtPSaE6MbMKG3kkcCWd8JGVjoe";
        String secretKey = "Y2ten8rYYYZfkvETBGSzB_pkVNLON0amvT-IkOel";
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);*/

    }

}
