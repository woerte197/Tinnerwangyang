package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.databinding.LayoutMorningfoodBinding;
import com.lib.DbHelperMode.DbHelperMode;
import com.lib.Manager.DialogManager;
import com.lib.Manager.PageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 1/2/18.
 */

public class ViewMorningFoodItemHolder extends BaseRecyclerHolder<FoodBean, LayoutMorningfoodBinding> {
    public ViewMorningFoodItemHolder(View itemView) {
        super(itemView);

    }


    @Override
    public void setUpView(FoodBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setFood(model);
        List<FoodBean> list = new ArrayList<>();
        list.add(model);
        bindView.linearFoodall.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DialogManager.getDialogManager().addfooddialog(context,DBhelper.FOOD_TABLE, model.get_id());
                return false;
            }
        });
    }


}
