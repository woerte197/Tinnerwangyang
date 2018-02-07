package com.lib.DbHelperMode;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.SportBean;
import com.example.wangyang.tinnerwangyang.Bean.WeightBean;
import com.example.wangyang.tinnerwangyang.DBhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangyang on 25/1/18.
 */

public class DbHelperMode {

    public static void insert(SQLiteDatabase db, String name, String pass) {
        ContentValues cValue = new ContentValues();
        cValue.put("Name", name);
        cValue.put("Password", pass);
        cValue.put("Nickname", "s");
        cValue.put("TelePhone", 1111);
        db.insert(DBhelper.TABLE_NAME, null, cValue);
    }

    public static void insertFood(SQLiteDatabase db, String name, int weight, int calorie, int type) {
        ContentValues cValue = new ContentValues();
        cValue.put("MorningFoodName", name);
        cValue.put("MorningWeight", weight);
        cValue.put("MorningCalorie", calorie);
        cValue.put("Type", type);
        db.insert(DBhelper.FOOD_TABLE, null, cValue);
    }

    public static void insertSport(SQLiteDatabase db, String name, int weight, int calorie, int type) {
        ContentValues cValue = new ContentValues();
        cValue.put("Aerobic", name);
        cValue.put("Anaerobic", weight);
        cValue.put("Stretching", calorie);
        cValue.put("Type", type);
        db.insert(DBhelper.SPORT_TABLE, null, cValue);
    }

    public static void insertWeight(SQLiteDatabase db, String name, String map, int type) {
        ContentValues cValue = new ContentValues();
        cValue.put("Map", map);
        cValue.put("Type", type);
        db.insert(DBhelper.WEIGHT_TABLE, null, cValue);
    }

    public static List<FoodBean> query(SQLiteDatabase db, String table) {
        Cursor cursor = db.query(table, null, null, null, null, null, null);
        return queryFoodBean(cursor);
    }

    public static List<SportBean> querysport(SQLiteDatabase db, String table) {
        Cursor cursor = db.query(table, null, null, null, null, null, null);
        return querySportsBean(cursor);
    }

    public static List<WeightBean> queryweight(SQLiteDatabase db, String table) {
        Cursor cursor = db.query(table, null, null, null, null, null, null);
        return queryWeightBean(cursor);
    }

    private static List<WeightBean> queryWeightBean(Cursor cursor) {
        List<WeightBean> weightBeanList = new ArrayList<>();
        if (cursor != null) {
            int cnt = cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < cnt; i++) {
                WeightBean weightBean = new WeightBean();
                weightBean.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                weightBean.setMap(cursor.getString(cursor.getColumnIndex("Map")));
                weightBean.setType(cursor.getInt(cursor.getColumnIndex("Type")));
                weightBeanList.add(weightBean);
                cursor.moveToNext();
            }
        }
        return weightBeanList;
    }

    private static List<FoodBean> queryFoodBean(Cursor cursor) {
        List<FoodBean> foodBeanList = new ArrayList<>();
        if (cursor != null) {
            int cnt = cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < cnt; i++) {
                FoodBean foodBean = new FoodBean();
                foodBean.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                foodBean.setMorningFoodName(cursor.getString(cursor.getColumnIndex("MorningFoodName")));
                foodBean.setMorningWeight(cursor.getInt(cursor.getColumnIndex("MorningWeight")));
                foodBean.setMorningCalorie(cursor.getInt(cursor.getColumnIndex("MorningCalorie")));
                foodBean.setType(cursor.getInt(cursor.getColumnIndex("Type")));
                foodBeanList.add(foodBean);
                cursor.moveToNext();
            }
        }
        return foodBeanList;
    }


    private static List<SportBean> querySportsBean(Cursor cursor) {
        List<SportBean> foodBeanList = new ArrayList<>();
        if (cursor != null) {
            int cnt = cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < cnt; i++) {
                SportBean sportBean = new SportBean();
                sportBean.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                sportBean.setSportname(cursor.getString(cursor.getColumnIndex("Aerobic")));
                sportBean.setSporttime(cursor.getInt(cursor.getColumnIndex("Anaerobic")));
                sportBean.setSportCalorie(cursor.getInt(cursor.getColumnIndex("Stretching")));
                sportBean.setType(cursor.getInt(cursor.getColumnIndex("Type")));
                foodBeanList.add(sportBean);
                cursor.moveToNext();
            }
        }
        return foodBeanList;
    }


    public static void deleteById(SQLiteDatabase db, String table, int _id) {
        String[] whereArgs = new String[]{"" + _id};
        db.delete(table, "_id=?", whereArgs);
    }

    public static int Quer(SQLiteDatabase db, String pwd, String name) {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        Cursor cursor = db.rawQuery(String.format("select * from %s where Name=? ", DBhelper.TABLE_NAME), new String[]{name});
        if (cursor.getCount() > 0) {
            Cursor pwdcursor = db.rawQuery(String.format("select * from %s where Password=? and Name=?", DBhelper.TABLE_NAME), new String[]{pwd, name});
            if (pwdcursor.getCount() > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    private void delete(SQLiteDatabase db) {
//删除条件
        String whereClause = "id=?";
//删除条件参数
        String[] whereArgs = {String.valueOf(2)};
//执行删除
        db.delete("stu_table", whereClause, whereArgs);
    }

    private void update(SQLiteDatabase db) {
//实例化内容值
        ContentValues values = new ContentValues();
//在values中添加内容
        values.put("snumber", "101003");
//修改条件
        String whereClause = "id=?";
//修改添加参数
        String[] whereArgs = {String.valueOf(1)};
//修改
        db.update("usertable", values, whereClause, whereArgs);
    }

}
