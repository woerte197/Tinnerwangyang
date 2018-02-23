package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.databinding.ActivityHealthHabitsBinding;

import java.util.List;

public class HealthHabitsActivity extends BaseActivity implements RefreshListListener {
    ActivityHealthHabitsBinding binding;
    private Request request;
    private RefreshNewsList<Knowledges> recyList;
    FootRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_health_habits);
        setSupportActionBar(binding.toolbarHealth);
        getSupportActionBar().setTitle("");
        binding.textHealth.setText("健康习惯");
        adapter = new FootRecyclerAdapter(this);
        binding.setP(() -> finish());
//        request = new Request(URLSetting.GET_JIANFEIYUANLI, Constant.TYPE_RESULT_NEWBEAN, URLSetting.URL_BASE);
//        recyList = new RefreshRecyList<>(adapter, binding.recycleYuanli, binding.refreshYuanli, request);
//        recyList.setLayoutManager(new GridLayoutManager(this, 1))
//                .setOldVersion(false)
//                .setRefreshListListener(this)
//                .addButtomListener()
//                .addTopListener();
//        recyList.loadTop();
        request = new Request();
        recyList = new RefreshNewsList<>(adapter, binding.recycleYuanli, binding.refreshYuanli, request, 4);
        recyList.setOldVersion(false)
                .setRefreshListListener(this)
                .setLayoutManager(new GridLayoutManager(this, 1))
                .addTopListener()
                .addButtomListener();
        recyList.loadTop();


    }

    @Override
    public void top(List list) {
        if (list != null) {
            adapter.addData(list);
        }
    }

    @Override
    public void topError(int error) {

    }

    @Override
    public void bottom(List list) {
        if (list != null) {
            adapter.addData(list);
        }
    }
}
