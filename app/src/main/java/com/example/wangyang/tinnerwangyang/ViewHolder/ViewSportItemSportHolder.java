package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Context;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.SportBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.databinding.LayoutSportsBinding;
import com.lib.Manager.DialogManager;

/**
 * Created by wangyang on 5/2/18.
 */

public class ViewSportItemSportHolder extends BaseRecyclerHolder<SportBean, LayoutSportsBinding> {


    public ViewSportItemSportHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(SportBean model, int position, BaseRecyclerAdapter adapter) {
        bindView.setSport(model);
        bindView.linearSportall.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DialogManager.getDialogManager().deletesportdialog(context, DBhelper.SPORT_TABLE,model.get_id());
                return false;
            }
        });
    }
}
