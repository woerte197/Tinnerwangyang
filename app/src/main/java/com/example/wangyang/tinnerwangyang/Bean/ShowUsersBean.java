package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 5/1/18.
 */

public  class ShowUsersBean implements Wachter{
    /**
     * id : 21253288
     * nickname : Linda丫丫妈妈
     * avatar_url : http://one.boohee.cn/t/2017/9/29/C4CCEAE1-4532-42EB-8D63-CC264A48C8A5.jpg?imageView2/1/w/90/h/90
     * following : false
     */

    private int id;
    private String nickname;
    private String avatar_url;
    private boolean following;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShowUsersBean{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", following=" + following +
                '}';
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

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
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