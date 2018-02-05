package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BigImageActivity;
import com.example.wangyang.tinnerwangyang.Activity.HealthHabitsActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.MyItem;
import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.common.SharePrefUtils;
import com.example.wangyang.tinnerwangyang.databinding.LayoutMyItemBinding;
import com.lib.Intent.Intentclass;
import com.lib.Manager.DialogManager;
import com.lib.Manager.EventBusManager;
import com.lib.Manager.PageManager;

/**
 * Created by wangyang on 23/1/18.
 */

public class ViewMyBodyItemHolder extends BaseRecyclerHolder<MyItem, LayoutMyItemBinding> {
    public ViewMyBodyItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(MyItem model, int position, BaseRecyclerAdapter adapter) {
        bindView.setMy(model);
        bindView.setContext(context);
        bindView.setP(wachter -> {
            int i = model.getJumperType();
            switch (i) {
                case 0:
                    Intentclass.IntentHealthHabitsActivity(context);
                    break;
                case 1:
                    Intentclass.IntentFoodaActivity(context,null);
                    break;
                case 2:
                    Intentclass.IntentWeightActivity(context, null, null);
                    break;
                case 3:
                    Intentclass.IntentSportsActivity(context);
                    break;
                case 4:
                    Intentclass.IntentTodayActicity(context);
                    break;
                case 5:
                    DialogManager.getDialogManager().logoutdialog(context);
                    break;
            }
        });
    }
}
