package com.example.wangyang.tinnerwangyang.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wangyang.tinnerwangyang.Bean.OfferTitle;

import java.util.List;

/**
 * Created by wangyang on 4/1/18.
 */

public class PageAdapter extends FragmentPagerAdapter {
    List<OfferTitle> list;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addData(List<OfferTitle> list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }

}
