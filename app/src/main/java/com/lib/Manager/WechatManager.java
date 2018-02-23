package com.lib.Manager;

import android.content.Context;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by wangyang on 11/2/18.
 */

public class WechatManager {
    private static WechatManager manager;
    private static IWXAPI iwxapi;
    private final static String APP_ID = "wx88888888";

    public static WechatManager getWechatManger(Context context) {
        if (manager == null) {
            synchronized (WechatManager.class) {
                manager = new WechatManager();
                iwxapi = WXAPIFactory.createWXAPI(context, APP_ID);
                iwxapi.registerApp(APP_ID);
            }
        }
        return manager;
    }

    public void loginWechat() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        iwxapi.sendReq(req);
    }
}
