package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 5/1/18.
 */

public  class HotEventsBean implements Wachter{
    /**
     * id : 48
     * title : 上周精选动态·第十九期
     * banner_url : http://up.boohee.cn/house/u/one/slider/20170807/20170807jxbanner.jpg
     * start_at : 2018-01-02
     * end_at : 2018-01-08
     * priority : 100
     * link_url : boohee://channel_posts/best_of_week_w19
     */

    private int id;
    private String title;
    private String banner_url;

    @Override
    public String toString() {
        return "HotEventsBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", banner_url='" + banner_url + '\'' +
                ", start_at='" + start_at + '\'' +
                ", end_at='" + end_at + '\'' +
                ", priority=" + priority +
                ", link_url='" + link_url + '\'' +
                '}';
    }

    private String start_at;
    private String end_at;
    private int priority;
    private String link_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
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
