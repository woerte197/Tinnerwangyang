package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.TodayItem;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.ActivityTodayStepBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TodayStepActivity extends BaseActivity {
    ActivityTodayStepBinding binding;
    BaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_today_step);
        //  binding.
        setSupportActionBar(binding.toolbarTodaystep);
        getSupportActionBar().setTitle("");
        binding.textTodaystep.setText("近日步数");

        initpage();
    }

    private void initpage() {
        int a = MainActivity.getTextstep();
        binding.textStep.setText(String.format("" + a));
        double b = (a * 0.7) / 1000;
        DecimalFormat df = new DecimalFormat("#.##");
        String c = df.format(b);
        double d = (b / 100) * 10;
        String e = df.format(d);
        double f = b * 60;
        String g = df.format(f);
        double h = f / 9;
        String i = df.format(h);
        binding.stepTextkm.setText("今天行走了  " + c + "  公里");
        binding.textGasoline.setText("相当于节省了  " + e + "  升汽油");
        binding.stepTextkk.setText("消耗了  " + g + "  千卡");
        binding.textFeat.setText("相当于燃烧了  " + i + "  克脂肪");
        binding.setP(() -> finish());
    }
}
