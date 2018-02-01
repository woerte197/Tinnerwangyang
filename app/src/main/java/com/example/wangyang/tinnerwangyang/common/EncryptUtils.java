package com.example.wangyang.tinnerwangyang.common;

/**
 * Created by wangyang on 3/1/18.
 */

import java.security.interfaces.RSAPublicKey;

/**
 * 加密解密处理
 */

public class EncryptUtils {
    public static String encodeRsa(RSAPublicKey publicKey, String data){
        return new String(Base64Utils.encode(RSAUtils.encryptData(data.getBytes(),publicKey)));
    }

    public static String decodeRc4(String privateKey, String data){
        return RC4.decry_RC4(Base64Utils.decode(data),privateKey);
    }

}
