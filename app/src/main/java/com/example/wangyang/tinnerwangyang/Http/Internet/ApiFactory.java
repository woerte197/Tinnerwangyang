package com.example.wangyang.tinnerwangyang.Http.Internet;

import com.example.wangyang.tinnerwangyang.URLSetting;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyang on 28/12/17.
 */

public class ApiFactory {
    private static  final String TAG="ApiFactory";
    private static HashMap<Class,ApiService> serviceMap =new HashMap<>();
    public static ApiService ins(){
        ApiService service=serviceMap.get(ApiService.class);
        if (service==null){
//            OkHttpClient.Builder okBuilder =new OkHttpClient.Builder();
//            okBuilder.readTimeout(30, TimeUnit.SECONDS);
//            okBuilder.writeTimeout(30,TimeUnit.SECONDS);
//            okBuilder.connectTimeout(30,TimeUnit.SECONDS);
//            okBuilder.addInterceptor(chain -> {
//                boolean isConnected =NetworkUtil.verifyNetwork();
//                if (isConnected){
//                    Response proceed = chain.proceed(chain.request());
//                    return proceed;
//                }else {
//                    throw new RuntimeException("请连接网络");
//                }
//            });
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .addNetworkInterceptor(interceptor)
                    .build();
            Retrofit retrofit=new Retrofit.Builder().baseUrl(URLSetting.URL_Recommend)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            service=retrofit.create(ApiService.class);
            serviceMap.put(ApiService.class,service);
        }
        return service;
    }
}
