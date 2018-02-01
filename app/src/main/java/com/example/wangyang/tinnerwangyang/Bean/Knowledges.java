package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 28/12/17.
 */

public class Knowledges implements Wachter{
    private String show_time;
    private int id;
    private String link_url;
    private String pic_url;
    private String title;
    private String first_category;
    private int click_count;
    private String knowledge_type;

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_category() {
        return first_category;
    }

    public void setFirst_category(String first_category) {
        this.first_category = first_category;
    }

    public int getClick_count() {
        return click_count;
    }

    public void setClick_count(int click_count) {
        this.click_count = click_count;
    }

    public String getKnowledge_type() {
        return knowledge_type;
    }

    public void setKnowledge_type(String knowledge_type) {
        this.knowledge_type = knowledge_type;
    }

    @Override
    public String toString() {
        return "Knowledges{" +
                "show_time='" + show_time + '\'' +
                ", id=" + id +
                ", link_url='" + link_url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", title='" + title + '\'' +
                ", first_category='" + first_category + '\'' +
                ", click_count=" + click_count +
                ", knowledge_type='" + knowledge_type + '\'' +
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
