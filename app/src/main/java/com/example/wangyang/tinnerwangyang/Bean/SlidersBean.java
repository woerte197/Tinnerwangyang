package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 5/1/18.
 */

public  class SlidersBean implements Wachter{
    /**
     * title : 老年表情包
     * url : https://one.boohee.com/store/pages/xnh?share=true
     * pic_url : http://up.boohee.cn/house/u/shop/ad_page/20171229/250banner.jpg
     */

    private String title;
    private String url;
    private String pic_url;

    @Override
    public String toString() {
        return "SlidersBean{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return null;
    }
}
