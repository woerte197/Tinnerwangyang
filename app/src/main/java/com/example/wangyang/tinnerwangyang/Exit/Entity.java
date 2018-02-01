package com.example.wangyang.tinnerwangyang.Exit;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by wangyang on 29/12/17.
 */

public class Entity {
    public Map<String,Object> map=new HashMap<>();
    public Map<String, RequestBody> create(){
        Map<String,RequestBody> map1=new HashMap<>();
        String jsonParams=Constant.GSON.toJson(map);
//        String sign = MD5Util.MD5(EncryptKey.getSecretKeyFromJni() + jsonParams);
//        map1.put("sign", RequestBody.create(MediaType.parse("text/plain"),sign));
        map1.put("jsonParams", RequestBody.create(MediaType.parse("text/plain"),jsonParams));
        return map1;
    }
}
