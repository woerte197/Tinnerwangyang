package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.databinding.ActivityAddFoodBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;

public class AddFoodActivity extends BaseActivity {
    ActivityAddFoodBinding binding;
    private FoodTitle foodTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_food);
        setSupportActionBar(binding.toolbarAddFood);
        getSupportActionBar().setTitle("");
        foodTitle=FoodTitle.getFoodTitle();
        int type = getIntent().getIntExtra("type", 0);
        if (type == 1) {
//            foodTitle.setMorningshow(true);
            binding.textAddfood.setText("添加早餐");
        } else if (type == 2) {
//            foodTitle.setNoonshow(true);
            binding.textAddfood.setText("添加午餐");
        }
        if (type == 3) {
//            foodTitle.setNightshow(true);
            binding.textAddfood.setText("添加晚餐");
        }
        binding.setP(() -> {
            String name = binding.editFoodName.getText().toString();
            String skaluli = binding.editFoodKaluli.getText().toString();
            String sweight = binding.editFoodWeight.getText().toString();
            if ("".equals(name)) {
                ViewUtils.showMessage("请输入食物名称");
                return;
            }
            if ("".equals(skaluli)) {
                ViewUtils.showMessage("请输入食物重量");
                return;
            }
            if ("".equals(sweight)) {
                ViewUtils.showMessage("请输入食物卡路里");
                return;
            }
            int kaluli = Integer.parseInt(skaluli);
            int weight = Integer.parseInt(sweight);
            DBhelper dBhelper = DBhelper.getDBhelper(AddFoodActivity.this);
            SQLiteDatabase database = dBhelper.getWritableDatabase();
            DbHelperMode.insertSport(database, name, weight, kaluli, type);
            finish();
        });
    }
}
