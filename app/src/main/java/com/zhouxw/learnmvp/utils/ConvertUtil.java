package com.zhouxw.learnmvp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author zhouxw
 */
public class ConvertUtil {

    /**
     * 随机数
     *
     * @param num
     * @return
     */
    public static String getRandom(int num) {
        Random random = new Random(num);
        int ran1 = 0;
        for (int i = 0; i < 5; i++) {
            ran1 = random.nextInt(100);
        }
        return String.valueOf(ran1);
    }

    /**
     * 将字符串转成MD5值
     *
     * @param string 需要加密的内容
     * @return 加密后的字符串
     */
    public static String stringToMD5(String string)  {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

}
