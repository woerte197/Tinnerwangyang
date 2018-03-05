package com.example.wangyang.tinnerwangyang.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.wangyang.tinnerwangyang.Adapter.FootRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.Http.Internet.ApiFactory;
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

public class VideoActivity extends BaseActivity implements RefreshListListener {
    ActivityVideoBinding binding;
    private Request request;
    private FootRecyclerAdapter adapter;
    private RefreshRecyList<Result> recyList;
    private GrassesBean grassesBean = (GrassesBean) getIntent().getSerializableExtra("grassesBean");
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video);
        initpage();
        initEvent();
        initdata();
    }

    private void initdata() {
        adapter = new FootRecyclerAdapter(this);
        binding.recycleVideo.setAdapter(adapter);
        chooseUrl(grassesBean);
        request = new Request(url, Constant.TYPE_RESULT_POSTSBEANS, URLSetting.URL_Recommend);
        recyList = new RefreshRecyList<Result>(adapter, binding.recycleVideo, binding.refreshVideo, request);
        recyList.setRefreshListListener(this)
                .setLayoutManager(new GridLayoutManager(this, 1))
                .setOldVersion(false)
                .addButtomListener()
                .addTopListener();
        recyList.loadTop();

    }

    private void initEvent() {
        binding.setP(() -> finish());
    }

    private void initpage() {
        setSupportActionBar(binding.toolbarVideo);
        getSupportActionBar().setTitle("");
        binding.textVideo.setText(grassesBean.getName());
    }

    private String chooseUrl(GrassesBean grassesBean) {
        switch (grassesBean.getId()) {
            case 8:
                url = URLSetting.URL_VIDEO;
                break;
            case 4:
                url = URLSetting.URL_VIDEO_FOOD;
                break;
            case 10:
                url = URLSetting.URL_VIDEO_NICE;
                break;
            case 7:
                url = URLSetting.URL_VIDEO_HEALTH;
                break;
            case 9:
                url = URLSetting.URL_VIDEO_HARDCANDY;
                break;
        }
        return url;

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
