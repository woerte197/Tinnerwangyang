package com.example.wangyang.tinnerwangyang.Bean;


import com.example.wangyang.tinnerwangyang.fragement.BaseFragment;

public class OfferTitle {
    private String title;
    private BaseFragment fragment;

    public OfferTitle(String title, BaseFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public OfferTitle() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public String toString() {
        return "OfferTitle{" +
                "title='" + title + '\'' +
                ", fragment=" + fragment +
                '}';
    }
}
