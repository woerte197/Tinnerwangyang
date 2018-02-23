package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.ImageView;

import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.lib.Manager.TecentManager;
import com.lib.Manager.WechatManager;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initEvent();
    }

    private void initEvent() {
        binding.setP(() -> {
            Intentclass.IntentRegisterActivity(this);
        });
        binding.setPre(() -> {
            initlogin();
        });
        binding.setPeye(() -> {
            int cursorIndex = binding.editPass.getSelectionStart();
            if (binding.editPass.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                binding.editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                binding.imgEye.setImageResource(R.drawable.icon_eye_show);
            } else {
                binding.editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                binding.imgEye.setImageResource(R.drawable.icon_eye_hide);
            }
            binding.editPass.setSelection(cursorIndex);
        });

        binding.setPqq(() -> {
            TecentManager.getIns().onLogin(LoginActivity.this, listener);

        });
        binding.setPwechat(() -> WechatManager.getWechatManger(this).loginWechat());
    }

    IUiListener listener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.i("values", String.valueOf(values));
            Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());
            TecentManager.getIns().initOpenidAndToken(values);
            TecentManager.getIns().getUserInfo(LoginActivity.this, listeneruserinfo);
        }
    };


    IUiListener listeneruserinfo = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            super.doComplete(values);
            SharePrefUtils.getInstance().setLoginUserName("name", 1);
            SharePrefUtils.getInstance().setMyBean(String.valueOf(values));
            finish();
        }
    };

    private void initlogin() {
        name = binding.editName.getText().toString();
        pass = binding.editPass.getText().toString();
        if (TextUtils.isEmpty(name)) {
            ViewUtils.showMessage("用户名不可以为空");
            return;
        } else if (TextUtils.isEmpty(pass)) {
            ViewUtils.showMessage("密码不可以为空");
            return;
        }
        DBhelper dBhelper = DBhelper.getDBhelper(this);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        int a = DbHelperMode.Quer(database, pass, name);
        if (a == 0) {
            ViewUtils.showMessage("用户不存在");
            return;
        }
        if (a == -1) {
            ViewUtils.showMessage("密码错误");
            return;
        }
        if (a == 1) {
            ViewUtils.showMessage("登录成功");
            SharePrefUtils.getInstance().setLoginUserName(name, 2);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN || requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, listener);
        }


    }
}
