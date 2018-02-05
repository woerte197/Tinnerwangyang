package com.lib.Intent;

import android.content.Context;
import android.content.Intent;

import com.example.wangyang.tinnerwangyang.Activity.AddFoodActivity;
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
import com.example.wangyang.tinnerwangyang.common.Setting;

/**
 * Created by wangyang on 25/1/18.
 */

public class Intentclass {

    public static void IntentLoginActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void IntentRegisterActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, RegisterActivity.class);
        context.startActivity(intent);
    }
    public static void IntentMainActivity(Context context,int value){
        Intent intent=new Intent();
        intent.putExtra(Setting.TABUSERFRAGMENT,value);
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }
    public static void IntentQueryActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, QueryActivity.class);
        context.startActivity(intent);
    }
    public static void IntentHealthHabitsActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, HealthHabitsActivity.class);
        context.startActivity(intent);
    }
    public static void IntentTodayActicity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, TodayStepActivity.class);
        context.startActivity(intent);
    }
    public static void IntentWebActivity(Context context, String url){
        Intent intent=new Intent();
        intent.putExtra("url",url);
        intent.setClass(context, WebActivity.class);
        context.startActivity(intent);
    }
    public static void IntentWeightActivity(Context context, String s,String d){
        Intent intent=new Intent();
        intent.putExtra("timeback",d);
        intent.putExtra("weight",s);
        intent.setClass(context, WeightActivity.class);
        context.startActivity(intent);
    }
    public static void IntentChooseWeightActivity(Context context,String d){
        Intent intent=new Intent();
        intent.putExtra("time",d);
        intent.setClass(context, ChooseWeightActivity.class);
        context.startActivity(intent);
    }
    public static void IntentFoodaActivity(Context context,FoodTitle type){
        Intent intent=new Intent();
        intent.putExtra("typea",type);
        intent.setClass(context, FoodActivity.class);
        context.startActivity(intent);
    }
    public static void IntentSportsActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, SportsActivity.class);
        context.startActivity(intent);
    }
    public static void IntentAddFoodActivity(Context context,int type){
        Intent intent=new Intent();
        intent.putExtra("type",type);
        intent.setClass(context,AddFoodActivity.class);
        context.startActivity(intent);
    }
}
