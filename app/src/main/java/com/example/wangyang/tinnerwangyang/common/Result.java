package com.example.wangyang.tinnerwangyang.common;

import com.example.wangyang.tinnerwangyang.Bean.Channel;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Bean.HotEventsBean;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.ShowUsersBean;
import com.example.wangyang.tinnerwangyang.Bean.SlidersBean;
import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * @param <T> 泛型 代表 具体的数据格式 ,包括单条数据格式,和多条数据格式. 这个参数是每一个结果bean中的格式,在书写bean请根据当前bean来书写
 * @author James Su
 *         从服务器返回的结果集
 */
public class Result<T> implements Wachter{
    //返回状态值
    private int result;
    //调试码
    private int errorcode;
    //消息码
    private String message;

    //时间戳
    private long timestamp;
    //返回的数据
    private T data;
    private List<T> articles;
    private boolean isEncrypt;
    private int total_pages;
    private int page;
    private List<T> sliders;
    private List<T> items;
    private List<T> tags;
    private T channel;
    private List<T> posts;
    private T user;
    private List<T> banners;
    private List<T> hot_posts;
    private List<T> grasses;
    private List<T> hot_events;
    private List<T> show_users;

    public List<T> getGrasses() {
        return grasses;
    }

    public void setGrasses(List<T> grasses) {
        this.grasses = grasses;
    }

    public List<T> getHot_events() {
        return hot_events;
    }

    public void setHot_events(List<T> hot_events) {
        this.hot_events = hot_events;
    }

    public List<T> getShow_users() {
        return show_users;
    }

    public void setShow_users(List<T> show_users) {
        this.show_users = show_users;
    }

    @Override

    public String toString() {
        return "Result{" +
                "result=" + result +
                ", errorcode=" + errorcode +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                ", articles=" + articles +
                ", isEncrypt=" + isEncrypt +
                ", total_pages=" + total_pages +
                ", page=" + page +
                ", sliders=" + sliders +
                ", items=" + items +
                ", tags=" + tags +
                ", channel=" + channel +
                ", posts=" + posts +
                ", user=" + user +
                ", banners=" + banners +
                ", hot_posts=" + hot_posts +
                '}';
    }

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public List<T> getBanners() {
        return banners;
    }

    public void setBanners(List<T> banners) {
        this.banners = banners;
    }

    public List<T> getHot_posts() {
        return hot_posts;
    }

    public void setHot_posts(List<T> hot_posts) {
        this.hot_posts = hot_posts;
    }

    public T getChannel() {
        return channel;
    }

    public void setChannel(T channel) {
        this.channel = channel;
    }

    public List<T> getPosts() {
        return posts;
    }

    public void setPosts(List<T> posts) {
        this.posts = posts;
    }


    public List<T> getSliders() {
        return sliders;
    }

    public void setSliders(List<T> sliders) {
        this.sliders = sliders;
    }

    public List<T> getTags() {
        return tags;
    }

    public void setTags(List<T> tags) {
        this.tags = tags;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
    // private List<T> tags;


    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getArticles() {
        return articles;
    }

    public void setArticles(List<T> articles) {
        this.articles = articles;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorcode;
    }

    public void setErrorCode(int code) {
        this.errorcode = code;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public int getResult() {
        return result;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
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