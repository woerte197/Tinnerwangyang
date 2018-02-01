package com.example.wangyang.tinnerwangyang.Http;

import android.util.Log;

import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.common.EncryptUtils;
import com.example.wangyang.tinnerwangyang.common.ErrorMessage;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.common.NetworkUnavailableException;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.common.Setting;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.common.StringUtils;
import com.google.gson.stream.JsonReader;


import org.json.JSONObject;

import java.io.StringReader;
import java.lang.reflect.Type;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;


public class HttpString<T> extends HttpBase<T> {

    private static final String TAG = HttpString.class.getSimpleName();
    private String value;

    public HttpString(String url, Type t,String baseurl) {
        super(url, t,baseurl);
    }

    public HttpString(Request request) {
        super(request);
    }

    public void execute() {
        compressFiles();
        if (url.isWithCache()) {
            handler.sendEmptyMessage(Setting.http_load_cache_success);
        }
        try {
            String u = url.getUrl();
            result.setResult(MessageCode.NET_ERROR);
            if (!SharePrefUtils.getInstance().isLogin()) {
                url.removeUserIdParam();
            }
            Log.i("httpstring:", "url:" + u + " pa : " + SharePrefUtils.getInstance().getLoginUserId() + " " + url.getJsonParams());
            byte[] resultBytes = HttpRequester.get(u, url.getJsonParams(), url.getHeaders());
            value = new String(resultBytes);
            if (url.isHttpGet()) {
                Result<String> resultGet = new Result();
                resultGet.setData(value);
                resultGet.setResult(0);
                result = (Result) resultGet;
            } else {
                Result tempResult = Constant.GSON.fromJson(value, Result.class);
                //处理错误
                if (tempResult.getResult() < 0) {
                    switch (tempResult.getErrorCode()) {
                        case ErrorMessage.ERROR_CODE_9102:
                            Observable.just(tempResult).observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(e -> {
                                        //	ECKit.getApp().getUserManager().logout(tempResult.getErrorCode());
                                    });
                            break;
                    }
                } else if (tempResult.isEncrypt()) {
                    //解密数据
                    String decodeData = EncryptUtils.decodeRc4(url.getPrivateKey(), (String) tempResult.getData());
                    //L.log(TAG, decodeData);
                    JSONObject obj = new JSONObject(value);
                    if ("null".equals(decodeData)) {
                        obj.put("data", null);
                    } else {
                        obj.put("data", new JSONObject(decodeData));
                    }
                    value = obj.toString();
                }
                Log.i("httpstring:", value);
                JsonReader reader = new JsonReader(new StringReader(value));
                reader.setLenient(true);
                result = Constant.GSON.fromJson(reader, url.getType());

                //	ECKit.getApp().getConfigManager().setServerTimeDiff(tempResult.getTimestamp());
            }
        } catch (NetworkUnavailableException e) {
            StringUtils.setResultData(result, MessageCode.NET_CONNECT, e);
        } catch (HttpResponseStatusErrorException e) {
            StringUtils.setResultData(result, MessageCode.NET_CONNECT, e);
        } catch (HttpTimeoutException e) {
            StringUtils.setResultData(result, MessageCode.NET_TIMEOUT, e);
        } catch (HttpBaseException e) {
            StringUtils.setResultData(result, MessageCode.NET_CONNECT, e);
        } catch (Exception e) {
            StringUtils.setResultData(result, MessageCode.NET_REFRESE, e);
        }
    }

    protected void compressFiles() {
    }

    public String getValue() {
        return value;
    }
}
