package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * Created by wangyang on 28/12/17.
 */

public class NewsBean implements Wachter {
    private List<Knowledges> knowledges;
    private int total_pages;
    private int page;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getCurrent_page() {
        return page;
    }

    public void setCurrent_page(int current_page) {
        this.page = current_page;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "knowledges=" + knowledges +
                '}';
    }

    public List<Knowledges> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<Knowledges> knowledges) {
        this.knowledges = knowledges;
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
