package com.lib.Manager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.BaseUiListener;
import com.example.wangyang.tinnerwangyang.Exit.MyApplication;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

/**
 * Created by wangyang on 7/2/18.
 */

public class TecentManager {
    private static TecentManager tecentManager;
    private static Tencent tencent;
    private static Context context = MyApplication.getMct();

    public static TecentManager getIns() {
        if (tecentManager == null) {
            synchronized (TecentManager.class) {
                if (tecentManager == null) {
                    tecentManager = new TecentManager();
                    Tecent();
                }
            }
        }
        return tecentManager;
    }

    public static void Tecent() {
        if (tencent == null) {
            tencent = Tencent.createInstance("222222", context);
        }
    }

    public void onLogin(BaseActivity activity, IUiListener listener) {
        if (!tencent.isSessionValid()) {
            tencent.login(activity, "all", listener);
        } else {
            tencent.logout(activity);
            tencent.login(activity, "all", listener);
        }
    }

    public void logout(Context context) {
        if (tencent != null && tencent.isSessionValid()) {
            tencent.logout(context);
        }
    }

    public void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                    && !TextUtils.isEmpty(openId)) {
                tencent.setAccessToken(token, expires);
                tencent.setOpenId(openId);
            }
        } catch (Exception e) {
        }
    }

    public void getUserInfo(BaseActivity activity, IUiListener listener) {
        if (tencent != null) {
            UserInfo userInfo = new UserInfo(activity, tencent.getQQToken());
            userInfo.getUserInfo(listener);
        }

    }


}

