package com.example.wangyang.tinnerwangyang.ViewModel;

import com.example.wangyang.tinnerwangyang.Http.Internet.ApiFactory;
import com.example.wangyang.tinnerwangyang.ViewUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by macmini on 2018/3/20.
 */

public class InterNetDataClass {
    public static InterNetDataClass interNetDataClass = null;
    public static DataPersent dataPersent;
    private String string = "网络连接错误";

    public static InterNetDataClass getInterNetDataClass(DataPersent d) {
        if (interNetDataClass == null) {
            synchronized (InterNetDataClass.class) {
                interNetDataClass = new InterNetDataClass();
            }
        }
        dataPersent = d;
        return interNetDataClass;
    }


    public void getQueryActivityData(String body) {
        ApiFactory.ins().getQueryList(body, 1, "UYPxayY3SxmRRhtfoG6N",
                "b3f61884-b31c-4320-85aa-56253204918e",
                "6.1.0.1", "Android",
                "7.0", "VTR-AL00", "huawei", "one")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((postsBeanResult) ->
                        dataPersent.success(postsBeanResult), throwable -> dataPersent.ennor(string)
                );
    }

    public void getRecommendFragementData() {
        ApiFactory.ins().getNewslist("UYPxayY3SxmRRhtfoG6N",
                "b3f61884-b31c-4320-85aa-56253204918e",
                "6.1.1", "Android",
                "7.0", "VTR-AL00", "boohee", "one")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((RecommendBean) -> dataPersent.success(RecommendBean), throwable -> dataPersent.ennor("请检查网络重试"));
    }

}
