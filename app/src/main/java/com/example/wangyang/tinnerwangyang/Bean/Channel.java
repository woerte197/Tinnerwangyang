package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 18/1/18.
 */

public class Channel {
    /**
     * id : 27
     * slug : hot_posts
     * title : 精选动态
     * posts_count : 43269
     * head_image_url : http://up.boohee.cn/house/u/one/others/bannertopic.png
     * page_url : http://m.boohee.com/knowledges/2015011401?share=true&app_installed=true
     */

    private int id;
    private String slug;
    private String title;
    private int posts_count;
    private String head_image_url;
    private String page_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(int posts_count) {
        this.posts_count = posts_count;
    }

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", posts_count=" + posts_count +
                ", head_image_url='" + head_image_url + '\'' +
                ", page_url='" + page_url + '\'' +
                '}';
    }
}
