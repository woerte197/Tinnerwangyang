package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.NewsTitle;
import com.example.wangyang.tinnerwangyang.databinding.NewsTitleItemBinding;

/**
 * Created by wangyang on 5/1/18.
 */

public class NewsTitleHolder extends BaseRecyclerHolder<NewsTitle, NewsTitleItemBinding> {
    public NewsTitleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(NewsTitle model, int position, BaseRecyclerAdapter adapter) {
        bindView.setTitle(model);
    }
}
