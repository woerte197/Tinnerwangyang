package com.lib.Manager;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.BaseUiListener;
import com.example.wangyang.tinnerwangyang.Exit.MyApplication;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

/**
 * Created by wangyang on 7/2/18.
 */

public class TecentManager {
    private static TecentManager tecentManager;
    private static Tencent tencent;
    private Context context = MyApplication.getMct();

    public static TecentManager getIns() {
        if (tecentManager == null) {
            synchronized (TecentManager.class) {
                if (tecentManager == null) {
                    tecentManager = new TecentManager();
                }
            }
        }
        return tecentManager;
    }


    public Tencent Tecent() {
        if (tencent == null) {
            tencent = Tencent.createInstance("222222", context);
        }
        return tencent;
    }

    public void login(BaseActivity activity) {
//        if (!tencent.isSessionValid()) {
//            tencent.login(activity,"all",listener);
////            isServerSideLogin = false;
//            Log.i("SDKQQAgentPref", "FirstLaunch_SDK:" + SystemClock.elapsedRealtime());
//        } else {
////            if (isServerSideLogin) { // Server-Side 模式的登陆, 先退出，再进行SSO登陆
//                tencent.logout(activity);
//                tencent.login(activity, "all", listener);
////                isServerSideLogin = false;
//                Log.i("SDKQQAgentPref", "FirstLaunch_SDK:" + SystemClock.elapsedRealtime());
//                return;
//            }
//            tencent.logout(activity);


    }

    private void getUserInfo() {

    }


}

