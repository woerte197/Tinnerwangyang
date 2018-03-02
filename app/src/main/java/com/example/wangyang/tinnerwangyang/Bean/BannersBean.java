package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 27/2/18.
 */

public class BannersBean {
    private int id;
    private String title;
    private String url;
    private String pic_url;
    private int priority;

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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "BannersBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", priority=" + priority +
                '}';
    }
}
