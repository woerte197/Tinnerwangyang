package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * Created by wangyang on 3/1/18.
 */

public class Success implements Wachter{

    private List<?> sliders;
    private List<ItemsBean> items;
    private List<TagsBean> tags;

    public List<?> getSliders() {
        return sliders;
    }

    public void setSliders(List<?> sliders) {
        this.sliders = sliders;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
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
