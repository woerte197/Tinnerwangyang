package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.MainActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.TodayItem;
import com.example.wangyang.tinnerwangyang.databinding.LayoutTodayItemBinding;

import java.text.DecimalFormat;

/**
 * Created by wangyang on 26/1/18.
 */

public class ViewTodayItemHolder extends BaseRecyclerHolder<TodayItem, LayoutTodayItemBinding> {
    public ViewTodayItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(TodayItem model, int position, BaseRecyclerAdapter adapter) {
        bindView.setContext(context);
        bindView.setToday(model);
        int a = MainActivity.getTextstep();


    }
}
