package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 11/2/18.
 */

public class ShareBean  implements Wachter{
    private String url;
    private String content;
    private String imageurl;
    private String title;

    @Override
    public String toString() {
        return "ShareBean{" +
                "url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
