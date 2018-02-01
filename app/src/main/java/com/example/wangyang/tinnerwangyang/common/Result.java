package com.example.wangyang.tinnerwangyang.common;

import com.example.wangyang.tinnerwangyang.Bean.Channel;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;

import java.util.List;

/**
 * @param <T> 泛型 代表 具体的数据格式 ,包括单条数据格式,和多条数据格式. 这个参数是每一个结果bean中的格式,在书写bean请根据当前bean来书写
 * @author James Su
 *         从服务器返回的结果集
 */
public class Result<T> {
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
    private Channel channel;
    private List<PostsBean> posts;


    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
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
                '}';
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

}