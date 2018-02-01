package com.example.wangyang.tinnerwangyang.Exit;

import com.example.wangyang.tinnerwangyang.common.Result;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wangyang on 29/12/17.
 */

public class Rxutils {
    public static <T>rx.Observable.Transformer<Result<T>,T> handleResult(){
        return new rx.Observable.Transformer<Result<T>, T>() {
            @Override
            public rx.Observable<T> call(rx.Observable<Result<T>> resultObservable) {
                return (rx.Observable<T>) resultObservable.flatMap(tResult -> {
                    return rx.Observable.create(subscriber -> {
                        if (tResult.getResult()==0){
                            subscriber.onNext(tResult.getData());
                            subscriber.onCompleted();

                        }else{

                            subscriber.onError(new Exception());
                            subscriber.onCompleted();
                        }
                    });
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
