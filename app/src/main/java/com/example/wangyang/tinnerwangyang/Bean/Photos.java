package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 18/1/18.
 */

public class Photos  implements Wachter{
    private String small_url;
    private String middle_url;
    private String big_url;
    private int preview_width;
    private int preview_height;
    private int origin_width;
    private int origin_height;

    public String getSmall_url() {
        return small_url;
    }

    public void setSmall_url(String small_url) {
        this.small_url = small_url;
    }

    public String getMiddle_url() {
        return middle_url;
    }

    public void setMiddle_url(String middle_url) {
        this.middle_url = middle_url;
    }

    public String getBig_url() {
        return big_url;
    }

    public void setBig_url(String big_url) {
        this.big_url = big_url;
    }

    public int getPreview_width() {
        return preview_width;
    }

    public void setPreview_width(int preview_width) {
        this.preview_width = preview_width;
    }

    public int getPreview_height() {
        return preview_height;
    }

    public void setPreview_height(int preview_height) {
        this.preview_height = preview_height;
    }

    public int getOrigin_width() {
        return origin_width;
    }

    public void setOrigin_width(int origin_width) {
        this.origin_width = origin_width;
    }

    public int getOrigin_height() {
        return origin_height;
    }

    public void setOrigin_height(int origin_height) {
        this.origin_height = origin_height;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "small_url='" + small_url + '\'' +
                ", middle_url='" + middle_url + '\'' +
                ", big_url='" + big_url + '\'' +
                ", preview_width=" + preview_width +
                ", preview_height=" + preview_height +
                ", origin_width=" + origin_width +
                ", origin_height=" + origin_height +
                '}';
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
