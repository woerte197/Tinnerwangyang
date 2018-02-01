package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;

public abstract class BaseRecyclerHolder<T, SV extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected SV bindView;
    protected Context context;
    protected LayoutInflater inflater;


    public BaseRecyclerHolder(View itemView) {
        super(itemView);
        bindView = DataBindingUtil.bind(itemView);
        bindView.executePendingBindings();
        context = itemView.getContext();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public abstract void setUpView(T model, int position, BaseRecyclerAdapter adapter);

    public void setKeyWords(String keyWords){

    }
    public SV getBindView(){
        return bindView;
    }
}
