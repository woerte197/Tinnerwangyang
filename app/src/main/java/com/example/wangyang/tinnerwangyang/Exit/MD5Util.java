package com.example.wangyang.tinnerwangyang.Exit;

import java.security.MessageDigest;

/**
 * Created by wangyang on 29/12/17.
 */

public class MD5Util {
    public final static String MD5(String s){
        char hexDigtis[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] bytes=s.getBytes();
            MessageDigest messageDigest =MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] md =messageDigest.digest();
            int j=md.length;
            char str[] =new char[j*2];
            int k=0;
            for (int i=0;i<j;i++){
                byte  byte0 =md[i];
                str[k++] =hexDigtis[byte0>>>4 & 0xf];
                str[k++]=hexDigtis[byte0 & 0xf];

            }
            return new String(str);
         }catch (Exception e){
            return  null;
        }
    }
    public static void main(String[] args) {
        System.out.println(MD5Util.MD5("20121221"));
        System.out.println(MD5Util.MD5("加密"));
    }
}
