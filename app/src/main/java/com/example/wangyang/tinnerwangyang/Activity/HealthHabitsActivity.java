package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.ActivityHealthHabitsBinding;

public class HealthHabitsActivity extends BaseActivity {
    ActivityHealthHabitsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_health_habits);
        setSupportActionBar(binding.toolbarHealth);
        getSupportActionBar().setTitle("");
        binding.textHealth.setText("健康习惯");
        binding.setP(() -> finish());
    }
}
