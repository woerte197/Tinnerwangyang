package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.SportBean;
import com.example.wangyang.tinnerwangyang.DBhelper;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutBackgroundBinding;
import com.lib.DbHelperMode.DbHelperMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2/2/18.
 */

public class ViewBackGroundItemHolder extends BaseRecyclerHolder<Background, LayoutBackgroundBinding> {
    private List<FoodBean> list;
    private List<SportBean> sportlist;
    private int a;

    public ViewBackGroundItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Background model, int position, BaseRecyclerAdapter adapter) {
        DBhelper dBhelper = DBhelper.getDBhelper(context);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        if (model.getThistype() == 1) {
            list = DbHelperMode.query(database, DBhelper.FOOD_TABLE);
            for (int i = 0; i < list.size(); i++) {
                a = a + list.get(i).getMorningCalorie();
            }
            bindView.textStep.setText(a + "");
            bindView.textTitle.setText("今日总摄入");
            bindView.propaso.setText("建议总摄入量： 1500~1800");
        }
        if (model.getThistype() == 2) {
            sportlist = DbHelperMode.querysport(database, DBhelper.SPORT_TABLE);
            for (int i = 0; i < sportlist.size(); i++) {
                a = a + sportlist.get(i).getSportCalorie();
            }
            bindView.textStep.setText(a + "");
            bindView.textTitle.setText("今日总消耗");
            bindView.propaso.setText("每消耗9千卡可以减掉一克脂肪哦！！！");
        }
    }
}
