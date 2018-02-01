package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 1/2/18.
 */

public class FoodTitle implements Wachter {
    private String title;
    private String time;
    private String button;


    public FoodTitle(String title, String time, String button) {
        this.time = time;
        this.title = title;
        this.button = button;
    }

    @Override
    public String toString() {
        return "FoodTitle{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", button='" + button + '\'' +
                '}';
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
