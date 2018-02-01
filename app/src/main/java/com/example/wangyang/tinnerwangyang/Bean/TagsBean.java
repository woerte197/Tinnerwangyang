package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * Created by wangyang on 9/1/18.
 */

public class TagsBean implements Wachter{

    /**
     * category : 身份
     * items : ["学生族","上班族","产后妈妈","自由职业","其他"]
     */

    private String category;
    private List<String> items;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
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