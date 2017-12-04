package com.gqxie.util.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xie Guoqiang
 * @date 2017-12-04 10:29:44
 */
public final class RandomUtil
{

    /**
     * 随机生成 num位数字字符
     *
     * @param num
     * @return
     */
    public static String getRandomNum(int num)
    {
        String chars = "0123456789";
        char[] rands = new char[num];
        for (int i = 0; i < num; i++)
        {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return String.valueOf(rands);
    }

    private RandomUtil()
    {

    }

}
