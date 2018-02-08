package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityAddSportsBinding;
import com.lib.DbHelperMode.DbHelperMode;

public class AddSportsActivity extends BaseActivity {
    ActivityAddSportsBinding binding;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_sports);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initpage();
        initEvent();
    }

    private void initpage() {
        setSupportActionBar(binding.toolbarAddSports);
        getSupportActionBar().setTitle("");
        type = getIntent().getIntExtra("sporttype", 0);
        if (type == 1) {
            binding.textAddsports.setText("添加有氧运动");
        } else if (type == 2) {
            binding.textAddsports.setText("添加无氧运动");
        } else if (type == 3) {
            binding.textAddsports.setText("添加拉伸运动");
        }
    }

    private void initEvent() {
        binding.setP(() -> {
            String name = binding.editSportName.getText().toString();
            String skaluli = binding.editSportWeight.getText().toString();
            String sweight = binding.editSportKaluli.getText().toString();
            if ("".equals(name)) {
                ViewUtils.showMessage("请输入运动名称");
                return;
            }
            if ("".equals(skaluli)) {
                ViewUtils.showMessage("请输入运动时间");
                return;
            }
            if ("".equals(sweight)) {
                ViewUtils.showMessage("请输入运动卡路里");
                return;
            }
            int kaluli = Integer.parseInt(skaluli);
            int weight = Integer.parseInt(sweight);
            DBhelper dBhelper = DBhelper.getDBhelper(AddSportsActivity.this);
            SQLiteDatabase database = dBhelper.getWritableDatabase();
            DbHelperMode.insertSport(database, name, weight, kaluli, type);
            finish();
        });
        binding.setPback(() -> finish());
    }

}
