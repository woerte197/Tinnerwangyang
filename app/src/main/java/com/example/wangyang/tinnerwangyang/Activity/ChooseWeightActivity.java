package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ScaleRuler.DecimalScaleRulerView;
import com.example.wangyang.tinnerwangyang.ScaleRuler.DrawUtil;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityChooseWeightBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;

public class ChooseWeightActivity extends BaseActivity {
    ActivityChooseWeightBinding binding;
    private float mWeight = 60.0f;
    private String d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = getIntent().getStringExtra("time");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_weight);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initpage();
        initp();
    }

    private void initpage() {

        setSupportActionBar(binding.toolbarChoseweight);
        getSupportActionBar().setTitle("");
        binding.textChoseweight.setText(R.string.chooseweight_write);
        binding.tvUserWeightValueTwo.setText(mWeight + "kg");
        binding.rulerWeight.setParam(DrawUtil.dip2px(10), DrawUtil.dip2px(32), DrawUtil.dip2px(24),
                DrawUtil.dip2px(14), DrawUtil.dip2px(9), DrawUtil.dip2px(12));
        binding.rulerWeight.initViewParam(mWeight, 20.0f, 200.0f, 1);
    }

    private void initp() {
        binding.rulerWeight.setValueChangeListener(new DecimalScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                binding.tvUserWeightValueTwo.setText(value + "kg");
                mWeight = value;
            }
        });
        binding.setP(() -> {
            SharePrefUtils.getInstance().setWeight(String.valueOf(mWeight), d);
            finish();
        });
    }

}
