package com.example.wangyang.tinnerwangyang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wangyang on 25/1/18.
 */
public class DBhelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "myTest.db";
    public static final String TABLE_NAME = "MyItem";
    public static final String FOOD_TABLE = "Food";;
    private static DBhelper dBhelper = null;
    private static final String FIELD_ID = "id";


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

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "CREATE TABLE " + FOOD_TABLE
                + "(_id INTEGER PRIMARY KEY,"
                + " MorningFoodName VARCHAR(30)  NOT NULL,"
                + " MorningWeight VARCHAR(20),"
                + " MorningCalorie VARCHAR(30),"
                + "Type VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);

    }

}
