package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.News;
import com.example.wangyang.tinnerwangyang.databinding.LayoutNewBinding;
import com.example.wangyang.tinnerwangyang.databinding.LayoutNewsBinding;

/**
 * Created by wangyang on 29/12/17.
 */

public class ViewNewHolder extends BaseRecyclerHolder<News, LayoutNewBinding> {
    public ViewNewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setUpView(News model, int position, BaseRecyclerAdapter adapter) {
        bindView.setKnowledges(model);
    }


}
