package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.Bean.SportBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.databinding.ActivitySportsBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;

import java.util.ArrayList;
import java.util.List;

public class SportsActivity extends BaseActivity {
    ActivitySportsBinding binding;
    private BaseRecyclerAdapter adapter;
    private List<SportBean> list;
    private List<Wachter> listwatch;
    private DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sports);
        initpage();
        initEvent();
        initadd();
    }

    private void initEvent() {
        binding.setPaerobic(() -> Intentclass.IntentAddSportsActivity(this, 1));
        binding.setPanaerobic(() -> Intentclass.IntentAddSportsActivity(this, 2));
        binding.setPstretching(() -> Intentclass.IntentAddSportsActivity(this, 3));
        binding.setP(() -> finish());
    }

    private void initpage() {
        setSupportActionBar(binding.toolbarSports);
        getSupportActionBar().setTitle("");
        binding.textSports.setText("运动记录");
        dBhelper = DBhelper.getDBhelper(this);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        list = DbHelperMode.querysport(database, DBhelper.SPORT_TABLE);
        listwatch = new ArrayList<>();
        Background background = new Background(2);
        listwatch.add(background);
        adapter = new BaseRecyclerAdapter(this);
        binding.recycleSports.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleSports.setAdapter(adapter);
    }

    private void initadd() {
        FoodTitle foodTitlea = new FoodTitle("有氧运动", "例如：   跑步  有氧", "及时记录哦");
        FoodTitle foodTitleb = new FoodTitle("无氧运动", "例如：   卧推  深蹲", "及时记录哦");
        FoodTitle foodTitlec = new FoodTitle("拉伸运动", "例如：   伟大的伸展", "及时记录哦");
        if (list.size() > 0) {
            listwatch.add(foodTitlea);
            for (SportBean f : list) {
                if (f.getSportType() == 1) {
                    listwatch.add(f);
                }
            }
            listwatch.add(foodTitleb);
            for (SportBean f : list) {
                if (f.getSportType() == 2) {
                    listwatch.add(f);
                }
            }
            listwatch.add(foodTitlec);
            for (SportBean f : list) {
                if (f.getSportType() == 3) {
                    listwatch.add(f);
                }
            }
        }
        adapter.addData(listwatch);
    }

    @Override
    public void update(int msg, Object args) {
        super.update(msg, args);
        switch (msg) {
            case MessageCode.ADD_FOOD:
                initpage();
                initadd();
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        initpage();
        initadd();
    }
}
