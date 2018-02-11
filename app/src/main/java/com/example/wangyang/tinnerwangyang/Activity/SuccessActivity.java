package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.ItemsBean;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.databinding.ActivitySuccessBinding;

import java.util.List;

public class SuccessActivity extends BaseActivity implements RefreshListListener {
    ActivitySuccessBinding binding;
    private Request request;
    private RefreshRecyList<ItemsBean> itemslist;
    private FootRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_success);
        initpage();
        initData();
    }

    private void initData() {
        setSupportActionBar(binding.toolbarSuccess);
        getSupportActionBar().setTitle("");
        binding.textSuccess.setText(R.string.success_tinner);
        binding.setP(() -> {
            finish();
        });
    }
    private void initpage() {
        request = new Request(URLSetting.SUCCESS_NEWS, Constant.TYPE_RESULT_ITEMBEANS, URLSetting.URL_Recommend);
        adapter = new FootRecyclerAdapter(this);
        itemslist = new RefreshRecyList<ItemsBean>(adapter, binding.recycleSuccess, binding.successRefreshlayout, request);
        itemslist.setLayoutManager(new GridLayoutManager(this, 1))
                .addButtomListener()
                .addTopListener()
                .setOldVersion(false)
                .setRefreshListListener(this);
        itemslist.loadTop();
//        request = new Request();
//        adapter = new FootRecyclerAdapter(this);
//        itemslist = new RefreshNewsList<>(adapter, binding.recycleSuccess, binding.successRefreshlayout, request,2);
//        itemslist.setLayoutManager(new GridLayoutManager(this, 1))
//                .addButtomListener()
//                .addTopListener()
//                .setOldVersion(true)
//                .setRefreshListListener(this);
//        itemslist.loadTop();

    }

    @Override
    public void top(List list) {
        List<Wachter> data = list;
        adapter.addData(data);
    }

    @Override
    public void topError(int error) {

    }

    @Override
    public void bottom(List list) {
        List<Wachter> data = list;
        adapter.addLoadData(data);
    }
}
