package com.example.wangyang.tinnerwangyang.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.UrlSettingBean;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.Http.Internet.ApiFactory;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.databinding.FragmentTabNewsBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TinnerSportsFragment extends BindFragment<FragmentTabNewsBinding> implements RefreshListListener {
    FootRecyclerAdapter adapter;
    RecyclerView recyclerView;
    private RefreshNewsList<Knowledges> newslist;
    public Request request;
    Toolbar toolbar;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initpage();
        adapter = new FootRecyclerAdapter(getActivity());
        recyclerView = bindView.recycleNews;
//        request = new Request(URLSetting.GET_SPORTS, Constant.TYPE_RESULT_NEWBEAN,URLSetting.URL_BASE);
//        newslist = new RefreshRecyList<Knowledges>(adapter, recyclerView, bindView.newsRefreshlayout, request);
//        newslist.setLayoutManager(new GridLayoutManager(getActivity(), 1))
//                .addButtomListener()
//                .addTopListener()
//                .setOldVersion(false)
//                .setRefreshListListener(this);
//        newslist.loadTop();
        request = new Request();
        newslist = new RefreshNewsList<>(adapter, recyclerView, bindView.newsRefreshlayout, request, 5);
        newslist.setLayoutManager(new GridLayoutManager(getActivity(), 1))
                .setRefreshListListener(this)
                .setOldVersion(false)
                .addButtomListener()
                .addTopListener();
        newslist.loadTop();
    }

    private void initpage() {
        getBaseActivity().setSupportActionBar(bindView.toolbar);
        getBaseActivity().getSupportActionBar().setTitle("");
        bindView.toolbarText.setText(R.string.tab_sport);
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_news;
    }


    @Override
    public void top(List list) {
        List<Wachter> data = list;
        adapter.addData(data);
        //  hideStatusView();
    }

    @Override
    public void topError(int error) {
        if (error == 1) {
            // showEmptyView(getString(R.string.msg_empty_block));
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