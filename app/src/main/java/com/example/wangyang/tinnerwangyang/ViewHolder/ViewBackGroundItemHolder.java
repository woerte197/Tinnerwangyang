package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutBackgroundBinding;
import com.lib.DbHelperMode.DbHelperMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2/2/18.
 */

public class ViewBackGroundItemHolder extends BaseRecyclerHolder<Background,LayoutBackgroundBinding> {
    private List<FoodBean> list;
    private int a;
    public ViewBackGroundItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Background model, int position, BaseRecyclerAdapter adapter) {
        DBhelper dBhelper=DBhelper.getDBhelper(context);
        SQLiteDatabase database=dBhelper.getReadableDatabase();
        list = DbHelperMode.query(database,DBhelper.FOOD_TABLE);
        for (int i=0;i<list.size();i++){
            a=a+list.get(i).getMorningCalorie();
        }
        bindView.textStep.setText(a+"");
    }
}
