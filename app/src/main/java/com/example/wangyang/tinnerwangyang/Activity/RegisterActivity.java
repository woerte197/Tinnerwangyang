package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityRegisterBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.lib.Manager.PageManager;

public class RegisterActivity extends Activity implements View.OnClickListener {
    ActivityRegisterBinding binding;
    private String name;
    private String pass;
    private final int USER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.registerButton.setOnClickListener(this);
        binding.setP(() -> {
            int countindex = binding.editPassRegister.getSelectionStart();
            if (binding.editPassRegister.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                binding.editPassRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                binding.imgEyeRegister.setImageResource(R.drawable.icon_eye_show);
            } else {
                binding.editPassRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
                binding.imgEyeRegister.setImageResource(R.drawable.icon_eye_hide);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_button:
                name = binding.editNameRegister.getText().toString();
                pass = binding.editPassRegister.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    ViewUtils.showMessage("手机号不可以为空");
                    return;
                } else if (TextUtils.isEmpty(pass)) {
                    ViewUtils.showMessage("密码不可以为空");
                    return;
                }
                DBhelper dBhelper = DBhelper.getDBhelper(RegisterActivity.this);
                SQLiteDatabase database = dBhelper.getWritableDatabase();
                DbHelperMode.insert(database, name, pass);
                ViewUtils.showMessage("注册成功");
                PageManager.getPageManager().pushLogin();
                SharePrefUtils.getInstance().setLoginUserName(name, 2);
                finish();
                break;
        }

    }
}
