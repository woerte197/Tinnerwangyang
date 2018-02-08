package com.example.wangyang.tinnerwangyang.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.example.wangyang.tinnerwangyang.Adapter.PageAdapter;
import com.example.wangyang.tinnerwangyang.Bean.OfferTitle;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.FragmentTabHomeBinding;
import com.youth.banner.transformer.RotateUpTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabHomeFragment extends BindFragment<FragmentTabHomeBinding> {
    RecommendFragment storyFragment;
    ChoiceFragment knowledgeFragment;
    PageAdapter adapter;
    List<OfferTitle> fragmentList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initpage();
    }

    private void initpage() {
        fragmentList = new ArrayList<>();
        adapter = new PageAdapter(getChildFragmentManager());
        storyFragment = new RecommendFragment();
        knowledgeFragment = new ChoiceFragment();
        fragmentList.add(new OfferTitle("推荐", storyFragment));
        fragmentList.add(new OfferTitle("精选", knowledgeFragment));
        adapter.addData(fragmentList);
        bindView.vpager.setAdapter(adapter);
        bindView.vpager.setOffscreenPageLimit(2);
        bindView.vpager.setPageTransformer(true, new RotateUpTransformer());
        bindView.tablayout.setupWithViewPager(bindView.vpager);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_home;
    }


}
