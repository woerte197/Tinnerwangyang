package com.example.wangyang.tinnerwangyang.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Bean.WeightBean;
import com.example.wangyang.tinnerwangyang.Calendarview.CalendarUtil;
import com.example.wangyang.tinnerwangyang.Calendarview.DateBean;
import com.example.wangyang.tinnerwangyang.Calendarview.OnPagerChangeListener;
import com.example.wangyang.tinnerwangyang.Calendarview.OnSingleChooseListener;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityWeightBinding;
import com.google.gson.Gson;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;

import java.util.HashMap;
import java.util.List;

public class WeightActivity extends BaseActivity {
    ActivityWeightBinding binding;
    private int[] date = CalendarUtil.getCurrentDate();
    private HashMap<String, String> map;
    private Gson g;
    private String weight;
    private List<WeightBean> list;
    private String stringmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weight);
        binding.title.setText(date[0] + "年" + date[1] + "月");
        initpage();
        initp();
    }

    private void initpage() {
        DBhelper dBhelper = DBhelper.getDBhelper(this);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        list = DbHelperMode.queryweight(database, DBhelper.WEIGHT_TABLE);
        for (WeightBean w : list) {
            stringmap = w.getMap();
        }
        map = new HashMap<>();
        weight = SharePrefUtils.getInstance().getWeightweight();
        setSupportActionBar(binding.toolbarWeight);
        getSupportActionBar().setTitle("");
        binding.textWeight.setText(R.string.weight_write);
        g = new Gson();
        if (stringmap != null) {
            map = g.fromJson(stringmap, HashMap.class);
        } else {
            map.put("2000.1.1", "77kg");
        }
        if (weight != null) {
            String d = SharePrefUtils.getInstance().getWeighttime();
            if (d != null) {
                map.put(d, weight);
                String a = g.toJson(map);
                SQLiteDatabase databasea = dBhelper.getWritableDatabase();
                DbHelperMode.insertWeight(databasea, DBhelper.WEIGHT_TABLE, a, 0);
            }
        }
        binding.calendar
                .setSpecifyMap(map)
                .setInitDate(date[0] + "." + date[1])
                .setStartEndDate("2000.1.1", "2049.1.1")
                .setSingleDate(date[0] + "." + date[1] + "." + date[2])
                .setDisableStartEndDate("2000.1.1", date[0] + "." + date[1] + "." + date[2])
                .init();
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
        });
        binding.setPreleft(() -> binding.calendar.lastMonth());
        binding.setPreright(() -> binding.calendar.nextMonth());
        binding.setP(() -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initpage();
        initp();
    }
}
