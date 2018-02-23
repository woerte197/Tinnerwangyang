package com.lib.Manager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;


import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Activity.RegisterActivity;
import com.example.wangyang.tinnerwangyang.Bean.ShareBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.common.StringUtils;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Intent.Intentclass;
import com.lib.view.FocusEditText;

import java.util.ArrayList;
import java.util.List;

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

    public void sharedialog(Context context, ShareBean shareBean) {
        AdapterView.OnItemClickListener itemlistener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 3:
                        TecentManager.getIns().sharetoqq((BaseActivity) context, shareBean);
                        break;
                    case 4:
                        ClipManager.getManager().getClipboard(context, shareBean.getUrl());
                        ViewUtils.showMessage("已经复制到粘贴板上");
                        break;


                }
            }
        };
        List<DialogItem> data = createShareDialogData(context);
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder.setTitle(StringUtils.getString(R.string.msg_dialog_title_share));
        customBuilder.createListAdapter(data, (BaseActivity) context, false, CustomDialog.type_gridview);
        customBuilder.setListener(itemlistener);
        CustomDialog dialog = customBuilder.create(CustomDialog.type_gridview);
        dialog.show();
    }

    private static List<DialogItem> createShareDialogData(Context ctx) {
        DialogItem item1 = new DialogItem(StringUtils.getString(R.string.msg_dialog_share_item_sina), false, R.drawable.ic_weibo);
        DialogItem item2 = new DialogItem(StringUtils.getString(R.string.msg_dialog_share_item_friend_group), false, R.drawable.ic_circlefriends);
        DialogItem item3 = new DialogItem(StringUtils.getString(R.string.msg_dialog_share_item_wexin_friend), false, R.drawable.ic_weixin);
        DialogItem item4 = new DialogItem(StringUtils.getString(R.string.msg_dialog_share_item_qq_friend), false, R.drawable.ic_qq);
        DialogItem item5 = new DialogItem(StringUtils.getString(R.string.msg_dialog_share_item_copy), false, R.drawable.ic_copy);
        ArrayList<DialogItem> data = new ArrayList<DialogItem>();
        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);
        return data;
    }

}
