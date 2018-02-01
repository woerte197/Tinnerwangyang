package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 18/1/18.
 */

public class UserBean {
    /**
     * id : 13852824
     * nickname : NICE服务
     * avatar_url : http://one.boohee.cn/t/2016/10/13/66F05760-5A51-4BC5-8327-69CEE317474C.jpg?imageView/1/w/120/h/120
     * title :
     * light : false
     */

    private int id;
    private String nickname;
    private String avatar_url;
    private String title;
    private boolean light;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }
}
