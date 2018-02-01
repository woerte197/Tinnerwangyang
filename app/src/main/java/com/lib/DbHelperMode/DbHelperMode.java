package com.lib.DbHelperMode;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
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

    public static void insertFood(SQLiteDatabase db, String name) {
        ContentValues cValue = new ContentValues();
        cValue.put("MorningFoodName", name);
        cValue.put("MorningWeight", 111);
        cValue.put("MorningCalorie", 111);
        db.insert(DBhelper.MORNING_TABLE, null, cValue);
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

    public static List<FoodBean> query(SQLiteDatabase db) {
//查询获得游标
        Cursor cursor = db.query(DBhelper.MORNING_TABLE, null, null, null, null, null, null);
        return queryFoodBean(cursor);
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
                foodBeanList.add(foodBean);
                cursor.moveToNext();
            }
        }
        return foodBeanList;
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

    public static String Quera(SQLiteDatabase db) {
        String sql = "select * from " + DBhelper.MORNING_TABLE;
        StringBuffer sb = new StringBuffer();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            sb.append("_id=").append(cursor.getString(cursor.getColumnIndex("_id"))).append(" ")
                    .append("MorningFoodName=").append(cursor.getString(cursor.getColumnIndex("MorningFoodName"))).append(" ")
                    .append("MorningWeight=").append(cursor.getInt(cursor.getColumnIndex("MorningWeight"))).append(" ")
                    .append("MorningCalorie=").append(cursor.getInt(cursor.getColumnIndex("MorningCalorie")))
                    .append("\n");
        }
        return String.valueOf(sb);
    }
}
