package com.example.wangyang.tinnerwangyang.Exit;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.wangyang.tinnerwangyang.ScaleRuler.DrawUtil;

/**
 * Created by wangyang on 28/12/17.
 */

public class MyApplication extends MultiDexApplication {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ECKit.onApplicationCreate(getApplicationContext());
        DrawUtil.resetDensity(this);
        this.context = getApplicationContext();

    }
    public static Context getMct(){
        return context;
    }
    public static MyApplication getApp(){
       return (MyApplication)context;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        ECKit.onApplicationTerminate();
    }
}
