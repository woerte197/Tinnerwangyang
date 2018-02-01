package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.ActivitySportsBinding;

public class SportsActivity extends BaseActivity {
    ActivitySportsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     binding= DataBindingUtil.setContentView(this,R.layout.activity_sports);
     setSupportActionBar(binding.toolbarSport);
     getSupportActionBar().setTitle("");
     binding.textSport.setText("运动记录");
    }
}
