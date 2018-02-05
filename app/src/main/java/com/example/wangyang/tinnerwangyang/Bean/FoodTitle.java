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
    private boolean morningshow = false;
    private boolean noonshow = false;
    private boolean nightshow = false;
    private static FoodTitle foodTitle = null;

    public static  FoodTitle getFoodTitle() {
        if (foodTitle == null) {
            foodTitle = new FoodTitle();

        }
        return foodTitle;
    }

    public boolean isShow() {
        return morningshow;
    }

    public boolean isMorningshow() {
        return morningshow;
    }

    public void setMorningshow(boolean morningshow) {
        this.morningshow = morningshow;
    }

    public boolean isNoonshow() {
        return noonshow;
    }

    public void setNoonshow(boolean noonshow) {
        this.noonshow = noonshow;
    }

    public boolean isNightshow() {
        return nightshow;
    }

    public void setNightshow(boolean nightshow) {
        this.nightshow = nightshow;
    }

    public void setShow(boolean show) {
        this.morningshow = show;
    }

    public FoodTitle() {
    }

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
