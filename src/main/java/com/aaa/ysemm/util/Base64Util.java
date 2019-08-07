package com.aaa.ysemm.util;

import sun.misc.BASE64Decoder;
import java.io.UnsupportedEncodingException;

public class Base64Util {
    /**
     *
     * 将 s 进行 BASE64 编码
     * base64 编码、解码util
     * 解码   编码字符格式必须一致
     * @return String
     */
    public static String encode(String s) {
        if (s == null)
            return null;
        String res = "";
        try {
            res = new sun.misc.BASE64Encoder().encode(s.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     */
    public static String decode(String s) {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b,"utf-8");
        } catch (Exception e) {
            return null;
        }
    }
    /**
     *
     * @return void
     */
    public static void main(String[] args) {
        System.out.println(Base64Util.encode("C:\\Users\\Administrator\\Desktop\\W%K`AACPL`OXWL[DA3Z89GI.jpeg"));
       // System.out.println(Base64Util.decode("uf65/g=="));

    }

}