package com.example.wangyang.tinnerwangyang.Activity;

import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * Created by wangyang on 6/2/18.
 */

public class BaseUiListener implements IUiListener {
    @Override
    public void onComplete(Object response) {
        if (null == response) {

            return;
        }
        JSONObject jsonResponse = (JSONObject) response;
        if (null != jsonResponse && jsonResponse.length() == 0) {

            return;
        }

        doComplete((JSONObject) response);
    }

    protected void doComplete(JSONObject values) {

    }

    @Override
    public void onError(UiError e) {

    }

    @Override
    public void onCancel() {
    }
}
