package com.example.wangyang.tinnerwangyang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wangyang on 25/1/18.
 */
public class DBhelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 8;
    private static final String DB_NAME = "myTest.db";
    public static final String TABLE_NAME = "MyItem";
    public static final String FOOD_TABLE = "Food";
    ;
    public static final String SPORT_TABLE = "Sport";
    private static DBhelper dBhelper = null;
    public static final String WEIGHT_TABLE = "Weights";


    public static DBhelper getDBhelper(Context context) {
        if (dBhelper == null) {
            dBhelper = new DBhelper(context);
        }
        return dBhelper;
    }

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create table " + TABLE_NAME + "(Name TEXT not null , Password TEXT not null , Nickname TEXT not null, TelePhone TEXT not null)";
        String sql1 = "CREATE TABLE " + FOOD_TABLE
                + "(_id INTEGER PRIMARY KEY,"
                + " MorningFoodName VARCHAR(30)  NOT NULL,"
                + " MorningWeight VARCHAR(20),"
                + " MorningCalorie VARCHAR(30),"
                + "Type VARCHAR(20))";
        String sql2 = "CREATE TABLE " + SPORT_TABLE
                + "(_id INTEGER PRIMARY KEY,"
                + " Aerobic VARCHAR(30)  NOT NULL,"
                + " Anaerobic VARCHAR(20),"
                + " Stretching VARCHAR(30),"
                + "Type VARCHAR(20))";
        String sql3 = "CREATE TABLE " + WEIGHT_TABLE
                + "(_id INTEGER PRIMARY KEY,"
                + " Map VARCHAR(30)  NOT NULL,"
                + "Type VARCHAR(20))";
        sqLiteDatabase.execSQL(sql3);
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql = "CREATE TABLE " + WEIGHT_TABLE
                + "(_id INTEGER PRIMARY KEY,"
                + " Map VARCHAR(30)  NOT NULL,"
                + "Type VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
    }

}
