package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.databinding.ActivityFoodBinding;
import com.google.gson.Gson;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.lib.Manager.DialogManager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends BaseActivity {
    ActivityFoodBinding binding;
    private static int MORNING_FOOD = 1;
    private static int NOON_FOOD = 2;
    private static int NIGHT_FOOD = 3;
    private List<FoodBean> list;
    private BaseRecyclerAdapter adapter;
    private List<Wachter> listwatch;
    FoodTitle foodTitlea = new FoodTitle("早餐记得吃哦", "建议：   439~536千卡", "及时记录哦");
    FoodTitle foodTitleb = new FoodTitle("午餐你吃了吗", "建议：   585~715千卡", "及时记录哦");
    FoodTitle foodTitlec = new FoodTitle("晚餐要少吃哦", "建议：   439~536千卡", "及时记录哦");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_food);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initpage();
        initadd();
        initevent();
    }

    private void initpage() {
        setSupportActionBar(binding.toolbarFood);
        getSupportActionBar().setTitle("");
        binding.textFood.setText("饮食记录");
        DBhelper dBhelper = DBhelper.getDBhelper(this);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        list = DbHelperMode.query(database, DBhelper.FOOD_TABLE);
        listwatch = new ArrayList<>();
        Background background = new Background(1);
        listwatch.add(background);
        adapter = new BaseRecyclerAdapter(this);
        binding.recycleFood.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleFood.setAdapter(adapter);
    }

    private void initevent() {
        binding.setPmorning(() -> {
            Intentclass.IntentAddFoodActivity(this, MORNING_FOOD);
        });
        binding.setPnoon(() -> {
            Intentclass.IntentAddFoodActivity(this, NOON_FOOD);
        });
        binding.setPnight(() -> {
            Intentclass.IntentAddFoodActivity(this, NIGHT_FOOD);
        });
        binding.setP(() -> finish());
    }

    private void initadd() {
        if (list.size() > 0) {
            listwatch.add(foodTitlea);
            for (FoodBean f : list) {
                if (f.getfoodType() == 1) {
                    listwatch.add(f);
                }
            }
            listwatch.add(foodTitleb);
            for (FoodBean f : list) {
                if (f.getfoodType() == 2) {
                    listwatch.add(f);
                }
            }
            listwatch.add(foodTitlec);
            for (FoodBean f : list) {
                if (f.getfoodType() == 3) {
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
