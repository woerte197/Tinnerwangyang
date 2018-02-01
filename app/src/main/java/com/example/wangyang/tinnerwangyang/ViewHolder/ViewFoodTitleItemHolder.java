package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.databinding.LayoutFoodtitleBinding;
import com.example.wangyang.tinnerwangyang.databinding.LayoutMorningfoodBinding;

/**
 * Created by wangyang on 1/2/18.
 */

public class ViewFoodTitleItemHolder extends BaseRecyclerHolder<FoodTitle,LayoutFoodtitleBinding> {
    public ViewFoodTitleItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(FoodTitle model, int position, BaseRecyclerAdapter adapter) {
        bindView.setFood(model);
    }
}
