package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.UrlSettingBean;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.databinding.ActivityKnowledgesBinding;
import com.lib.Manager.FileUtils;

import java.util.List;

public class KnowledgesActivity extends BaseActivity implements RefreshListListener {
    ActivityKnowledgesBinding binding;
    FootRecyclerAdapter adapter=new FootRecyclerAdapter(this);;
    RecyclerView recyclerView;
    private RefreshNewsList<Knowledges> newslist;
    public Request request;
    private UrlSettingBean urlBean;
    private List records;
    private boolean hasMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_knowledges);
        initpage();
        initData();
    }

    private void initpage() {
        recyclerView = binding.recycleNews;
        setSupportActionBar(binding.toolbarKnowledges);
        getSupportActionBar().setTitle("");
        binding.textKnowledges.setText(R.string.knowledges_tinner);
        binding.setP(()->{
            finish();
        });

    }


    private void initData() {
//        adapter=new FootRecyclerAdapter(this);
//        request = new Request(URLSetting.GET_NEWS, Constant.TYPE_RESULT_NEWBEAN, URLSetting.URL_BASE);
//        newslist = new RefreshRecyList<Knowledges>(adapter, recyclerView, binding.newsRefreshlayout, request);
//        newslist.setLayoutManager(new GridLayoutManager(this, 1))
//                .addButtomListener()
//                .addTopListener()
//                .setOldVersion(false)
//                .setRefreshListListener(this);

        request = new Request();
        newslist = new RefreshNewsList<Knowledges>(adapter, recyclerView, binding.newsRefreshlayout, request,1);
        newslist.setLayoutManager(new GridLayoutManager(this, 1))
                .addButtomListener()
                .addTopListener()
                .setRefreshListListener(this);
        newslist.loadTop();
    }


    @Override
    public void top(List list) {
        List<Wachter> data = list;
        adapter.addData(data);
    }

    @Override
    public void topError(int error) {
        if (error == 1) {
//             showEmptyView(getString(R.string.msg_empty_block));
        } else if (error == 0) {
            //  showErrorView();

        }
    }

    @Override
    public void bottom(List list) {
        List<Wachter> data = list;
        adapter.addLoadData(data);
    }
}
