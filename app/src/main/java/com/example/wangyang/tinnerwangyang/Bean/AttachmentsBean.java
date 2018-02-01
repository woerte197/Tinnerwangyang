package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 18/1/18.
 */

public class AttachmentsBean {
    /**
     * type : video
     * title : #太阳猫美食TV# 佛系养生粥底火锅，连锅都舔干净了！
     * pic : http://image.pearvideo.com/main/20180117/10699136-181054-0.png
     * url : http://video.pearvideo.com/mp4/third/20180117/10699136_180220-fhd.mp4
     * cover : http://image.pearvideo.com/main/20180117/10699136-181054-0.png
     */

    private String type;
    private String title;
    private String pic;
    private String url;
    private String cover;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "AttachmentsBean{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
