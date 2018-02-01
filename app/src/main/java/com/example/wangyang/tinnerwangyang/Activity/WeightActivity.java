package com.example.wangyang.tinnerwangyang.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Calendarview.CalendarUtil;
import com.example.wangyang.tinnerwangyang.Calendarview.DateBean;
import com.example.wangyang.tinnerwangyang.Calendarview.OnPagerChangeListener;
import com.example.wangyang.tinnerwangyang.Calendarview.OnSingleChooseListener;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityWeightBinding;
import com.google.gson.Gson;
import com.lib.Intent.Intentclass;

import java.util.HashMap;

public class WeightActivity extends BaseActivity {
    ActivityWeightBinding binding;
    private int[] date = CalendarUtil.getCurrentDate();
    private HashMap<String, String> map;
    private Gson g;
    private String weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weight);
        binding.title.setText(date[0] + "年" + date[1] + "月");
        initweight();
        initpage();
        initp();


    }

    private void initweight() {

    }

    private void initpage() {
        map = new HashMap<>();
        weight = getIntent().getStringExtra("weight");
        setSupportActionBar(binding.toolbarWeight);
        getSupportActionBar().setTitle("");
        binding.textWeight.setText(R.string.weight_write);
        g = new Gson();
        String s = SharePrefUtils.getInstance().getWeight();
        if (!"".equals(s)) {
            map = g.fromJson(s, HashMap.class);
        } else {
            map.put("2000.1.1", "77kg");
        }

        binding.calendar
                .setSpecifyMap(map)
                .setInitDate(date[0] + "." + date[1])
                .setStartEndDate("2000.1.1", "2049.1.1")
                .setSingleDate(date[0] + "." + date[1] + "." + date[2])
                .setDisableStartEndDate("2000.1.1", date[0] + "." + date[1] + "." + date[2])
                .init();
        if (weight != null) {
            String d = getIntent().getStringExtra("timeback");
            if (d != null) {
                map.put(d, weight);
                String a = g.toJson(map);
                SharePrefUtils.getInstance().setweight(a);
            }
        }

    }

    private void initp() {
        binding.calendar.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                binding.title.setText(date[0] + "年" + date[1] + "月");
            }
        });
        binding.calendar.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean date) {
                binding.title.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月");
                if (date.getType() == 1) {
                }
            }
        });
        binding.setPre(() -> {
            DateBean dateBean = binding.calendar.getSingleDate();
            String d = dateBean.getSolar()[0] + "." + dateBean.getSolar()[1] + "." + dateBean.getSolar()[2];
            Intentclass.IntentChooseWeightActivity(WeightActivity.this, d);
            finish();
        });
        binding.setPreleft(() -> binding.calendar.lastMonth());
        binding.setPreright(() -> binding.calendar.nextMonth());
        binding.setP(() -> finish());
    }


}
