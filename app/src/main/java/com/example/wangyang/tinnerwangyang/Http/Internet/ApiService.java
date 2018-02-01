package com.example.wangyang.tinnerwangyang.Http.Internet;



import com.example.wangyang.tinnerwangyang.Bean.NewsBean;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.Bean.Success;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.common.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by wangyang on 28/12/17.
 */

public interface ApiService {
//    @Multipart

//    @POST(URLSetting.GET_NEWS)
//    Observable<Result<NewsBean>> getNewsRecommend(@PartMap Map<String, RequestBody> jsonParams);

    @GET
    Call<NewsBean> getNews(@Url String url);

    @GET(URLSetting.RECOMMEND_NEWS)
    Observable<RecommendBean> getNewslist(@Query("token") String tooken,
                                          @Query("user_key") String user_key,
                                          @Query("app_version") String app_version,
                                          @Query("app_device") String app_device,
                                          @Query("os_version") String os_version,
                                          @Query("phone_model") String phone_model,
                                          @Query("channel") String channel,
                                          @Query("app_key") String app_key
    );
    @GET(URLSetting.SUCCESS_NEWS)
    Call<Success> getSuccessLisr(@Query("page") int page,
                                 @Query("token") String token);
    @GET(URLSetting.URL_QUERY)
    Observable<Result<PostsBean>> getQueryList(@Query("body")String body,
                                        @Query("page")int page,
                                        @Query("token") String token,
                                        @Query("user_key") String user_key,
                                        @Query("app_version") String app_version,
                                        @Query("app_device") String app_device,
                                        @Query("os_version") String os_version,
                                        @Query("phone_model") String phone_model,
                                        @Query("channel") String channel,
                                        @Query("app_key") String app_key);
    
}