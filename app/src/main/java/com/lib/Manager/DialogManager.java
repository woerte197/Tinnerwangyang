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
//        builder.setIcon(R.drawable.welcome);
        customBuilder.setTitle("退出登录")
                .setMessage("你确定要退出登录吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        SharePrefUtils.getInstance().clear();
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

    public void addfooddialog(Context context, int a) {
        FocusEditText editText = new FocusEditText(context);
        int title = 0;
        switch (a) {
            case 1:
                title = R.string.pelese_add_morningfood;
                break;
            case 2:
                title = R.string.pelese_add_noonfood;
                break;
            case 3:
                title = R.string.pelese_add_nightfood;
                break;
        }
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder.setTitle(title)
                .setContentView(editText)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        String s =editText.getText().toString();
                        DBhelper dBhelper=DBhelper.getDBhelper(context);
                        SQLiteDatabase database=dBhelper.getWritableDatabase();
                        DbHelperMode.insertFood(database,s);
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
