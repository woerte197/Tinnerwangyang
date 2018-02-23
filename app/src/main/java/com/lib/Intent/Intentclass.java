package com.lib.Intent;

import android.content.Context;
import android.content.Intent;

import com.example.wangyang.tinnerwangyang.Activity.AddFoodActivity;
import com.example.wangyang.tinnerwangyang.Activity.AddSportsActivity;
import com.example.wangyang.tinnerwangyang.Activity.ChooseWeightActivity;
import com.example.wangyang.tinnerwangyang.Activity.FoodActivity;
import com.example.wangyang.tinnerwangyang.Activity.HealthHabitsActivity;
import com.example.wangyang.tinnerwangyang.Activity.LoginActivity;
import com.example.wangyang.tinnerwangyang.Activity.MainActivity;
import com.example.wangyang.tinnerwangyang.Activity.QueryActivity;
import com.example.wangyang.tinnerwangyang.Activity.RegisterActivity;
import com.example.wangyang.tinnerwangyang.Activity.SportsActivity;
import com.example.wangyang.tinnerwangyang.Activity.TodayStepActivity;
import com.example.wangyang.tinnerwangyang.Activity.WebActivity;
import com.example.wangyang.tinnerwangyang.Activity.WeightActivity;
import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.Setting;

/**
 * Created by wangyang on 25/1/18.
 */

public class Intentclass {
    private static Intent intent = new Intent();

    public static void IntentLoginActivity(Context context) {
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void IntentRegisterActivity(Context context) {
        intent.setClass(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    public static void IntentMainActivity(Context context, int value, MyBean myBean) {
        intent.putExtra("logintype", myBean);
        intent.putExtra(Setting.TABUSERFRAGMENT, value);
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void IntentQueryActivity(Context context) {
        intent.setClass(context, QueryActivity.class);
        context.startActivity(intent);
    }

    public static void IntentHealthHabitsActivity(Context context) {
        intent.setClass(context, HealthHabitsActivity.class);
        context.startActivity(intent);
    }

    public static void IntentTodayActicity(Context context) {
        intent.setClass(context, TodayStepActivity.class);
        context.startActivity(intent);
    }

    public static void IntentWebActivity(Context context, ShareBean model) {
        intent.putExtra("url",model);
        intent.setClass(context, WebActivity.class);
        context.startActivity(intent);
    }

    public static void IntentWeightActivity(Context context, String s, String d) {
        intent.putExtra("timeback", d);
        intent.putExtra("weight", s);
        intent.setClass(context, WeightActivity.class);
        context.startActivity(intent);
    }

    public static void IntentChooseWeightActivity(Context context, String d) {
        intent.putExtra("time", d);
        intent.setClass(context, ChooseWeightActivity.class);
        context.startActivity(intent);
    }

    public static void IntentFoodaActivity(Context context, FoodTitle type) {
        intent.putExtra("typea", type);
        intent.setClass(context, FoodActivity.class);
        context.startActivity(intent);
    }

    public static void IntentSportsActivity(Context context) {
        intent.setClass(context, SportsActivity.class);
        context.startActivity(intent);
    }

    public static void IntentAddFoodActivity(Context context, int type) {
        intent.putExtra("type", type);
        intent.setClass(context, AddFoodActivity.class);
        context.startActivity(intent);
    }

    public static void IntentAddSportsActivity(Context context, int type) {
        intent.putExtra("sporttype", type);
        intent.setClass(context, AddSportsActivity.class);
        context.startActivity(intent);
    }

}
