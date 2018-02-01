package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BigImageActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Photos;
import com.example.wangyang.tinnerwangyang.databinding.LayoutImageBinding;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by wangyang on 18/1/18.
 */

public class ViewImageItemHolder extends BaseRecyclerHolder<Photos, LayoutImageBinding> {
    private static final String TAG = ViewImageItemHolder.class.getSimpleName();
    public ViewImageItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Photos model, int position, BaseRecyclerAdapter adapter) {
        bindView.setPhotos(model);
        Log.i(TAG, String.format("" + model.getBig_url()));
        bindView.setClick(() -> {
            Intent intent = new Intent();
            intent.putExtra("imageList", (Serializable) adapter.getDatas());
            intent.putExtra("imageid", position);
            intent.setClass(context, BigImageActivity.class);
            context.startActivity(intent);
        });
        Log.i(TAG, model.getBig_url());
    }
}
