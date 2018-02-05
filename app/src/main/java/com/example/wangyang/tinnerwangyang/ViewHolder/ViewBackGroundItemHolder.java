package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.databinding.LayoutBackgroundBinding;

/**
 * Created by wangyang on 2/2/18.
 */

public class ViewBackGroundItemHolder extends BaseRecyclerHolder<Background,LayoutBackgroundBinding> {
    public ViewBackGroundItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Background model, int position, BaseRecyclerAdapter adapter) {

    }
}
