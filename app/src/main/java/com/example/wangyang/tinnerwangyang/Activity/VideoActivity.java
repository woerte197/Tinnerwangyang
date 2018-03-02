package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.common.RefreshListListener;
import com.example.wangyang.tinnerwangyang.common.RefreshNewsList;
import com.example.wangyang.tinnerwangyang.common.RefreshRecyList;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.databinding.ActivityVideoBinding;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.Vitamio;

public class VideoActivity extends Activity implements RefreshListListener {
    ActivityVideoBinding binding;
    private Request request;
    private FootRecyclerAdapter adapter;
    private RefreshRecyList<Result> recyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_video);
        adapter = new FootRecyclerAdapter(this);
        binding.recycleVideo.setAdapter(adapter);
        request = new Request(URLSetting.URL_VIDEO, Constant.TYPE_RESULT_POSTSBEANS, URLSetting.URL_Recommend);
        recyList = new RefreshRecyList<Result>(adapter, binding.recycleVideo, binding.refreshVideo, request);
        recyList.setRefreshListListener(this)
                .setLayoutManager(new GridLayoutManager(this, 1))
                .setOldVersion(false)
                .addButtomListener()
                .addTopListener();
        recyList.loadTop();

    }

    @Override
    public void top(List list) {
        List<Wachter> list1 = new ArrayList<>();
        list1.addAll(list);
        adapter.addData(list1);

    }

    @Override
    public void topError(int error) {

    }

    @Override
    public void bottom(List list) {
        adapter.addData(list);
    }
}
