package com.lib.Manager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;


import com.example.wangyang.tinnerwangyang.Activity.RegisterActivity;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.lib.view.FocusEditText;

/**
 * Created by wangyang on 26/1/18.
 */

public class DialogManager {
    private static DialogManager dialogManager;

    public static DialogManager getDialogManager() {
        if (dialogManager == null) {
            dialogManager = new DialogManager();
        }
        return dialogManager;
    }

    public void logoutdialog(Context context) {
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder.setTitle("退出登录")
                .setMessage("你确定要退出登录吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        SharePrefUtils.getInstance().clear();
                        TecentManager.getIns().logout(context);
                        PageManager.getPageManager().pushLogout();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        CustomDialog builder = customBuilder.create();
        builder.show();
    }

    public void addfooddialog(Context context, String table, int a) {
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder.setTitle("删除食物记录")
                .setMessage("你确定要删除此条食物记录吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        DBhelper dBhelper = DBhelper.getDBhelper(context);
                        SQLiteDatabase database = dBhelper.getReadableDatabase();
                        DbHelperMode.deleteById(database, table, a);
                        PageManager.getPageManager().pushDelete();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        CustomDialog builder = customBuilder.create();
        builder.show();
    }

    public void deletesportdialog(Context context, String table, int a) {
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder.setTitle("删除运动记录")
                .setMessage("你确定要删除此条运动记录吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        DBhelper dBhelper = DBhelper.getDBhelper(context);
                        SQLiteDatabase database = dBhelper.getReadableDatabase();
                        DbHelperMode.deleteById(database, table, a);
                        PageManager.getPageManager().pushDelete();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        CustomDialog builder = customBuilder.create();
        builder.show();
    }
}
