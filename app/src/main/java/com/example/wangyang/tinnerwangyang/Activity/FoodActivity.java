package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.ActivityFoodBinding;
import com.google.gson.Gson;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Manager.DialogManager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends BaseActivity {
    ActivityFoodBinding binding;
    private static int MORNING_FOOD = 1;
    private static int NOON_FOOD = 2;
    private static int NIGHT_FOOD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_food);
        setSupportActionBar(binding.toolbarFood);
        getSupportActionBar().setTitle("");
        binding.textFood.setText("饮食记录");
        binding.setPmorning(() -> DialogManager.getDialogManager().addfooddialog(this, MORNING_FOOD));
        binding.setPnoon(() -> DialogManager.getDialogManager().addfooddialog(this, NOON_FOOD));
        binding.setPnight(() -> DialogManager.getDialogManager().addfooddialog(this, NIGHT_FOOD));
        binding.setP(() -> finish());
        DBhelper dBhelper=DBhelper.getDBhelper(this);
        SQLiteDatabase database=dBhelper.getReadableDatabase();
        String s= DbHelperMode.Quera(database);
        List<String> list=new ArrayList<>();
        list.add(s);
        Log.i("sad", String.valueOf(list));
        Gson gson=new Gson();

    }
}
