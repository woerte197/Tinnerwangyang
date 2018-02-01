package com.example.wangyang.tinnerwangyang;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.ViewHolder.BaseRecyclerHolder;
import com.example.wangyang.tinnerwangyang.databinding.RecyclerFooterItemBinding;

/**
 * Created by wangyang on 3/1/18.
 */

public class FooterHold extends BaseRecyclerHolder<FooterItem, RecyclerFooterItemBinding> {

    public FooterHold(View itemView) {
        super(itemView);

    }

    @Override
    public void setUpView(FooterItem model, int position, BaseRecyclerAdapter adapter) {
        bindView.setVariable(BR.footItem, model);
        bindView.executePendingBindings();
    }


}
