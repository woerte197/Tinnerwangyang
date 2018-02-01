package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * Created by wangyang on 5/1/18.
 */

public class RecommendBean implements Wachter {

    private List<SlidersBean> sliders;
    private List<GrassesBean> grasses;
    private List<HotEventsBean> hot_events;
    private List<ShowUsersBean> show_users;

    public List<SlidersBean> getSliders() {
        return sliders;
    }

    public void setSliders(List<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    @Override
    public String toString() {
        return "RecommendBean{" +
                "sliders=" + sliders +
                ", grasses=" + grasses +
                ", hot_events=" + hot_events +
                ", show_users=" + show_users +
                '}';
    }

    public List<GrassesBean> getGrasses() {
        return grasses;
    }

    public void setGrasses(List<GrassesBean> grasses) {
        this.grasses = grasses;
    }

    public List<HotEventsBean> getHot_events() {
        return hot_events;
    }

    public void setHot_events(List<HotEventsBean> hot_events) {
        this.hot_events = hot_events;
    }

    public List<ShowUsersBean> getShow_users() {
        return show_users;
    }

    public void setShow_users(List<ShowUsersBean> show_users) {
        this.show_users = show_users;
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
