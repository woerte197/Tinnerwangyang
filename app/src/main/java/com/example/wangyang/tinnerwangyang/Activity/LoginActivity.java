package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;

import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityLoginBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private String name;
    private String pass;
    private Tencent tencent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        tencent = Tencent.createInstance("222222", this);
        initpage();
    }

    IUiListener listener = new BaseUiListener() {

        protected void doComplete(JSONObject values) {
            try {
                String token = values.getString(Constants.PARAM_ACCESS_TOKEN);
                String expires = values.getString(Constants.PARAM_EXPIRES_IN);
                String openId = values.getString(Constants.PARAM_OPEN_ID);
                if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                        && !TextUtils.isEmpty(openId)) {
                    tencent.setAccessToken(token, expires);
                    tencent.setOpenId(openId);
                }
            } catch (Exception e) {
            }
        }
    };

    private void initpage() {
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
              tencent.login(this,"all",listener);
        });
    }

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
            SharePrefUtils.getInstance().setLoginUserName(name);
            Intentclass.IntentMainActivity(this, 3);
            finish();
        }
    }


}
