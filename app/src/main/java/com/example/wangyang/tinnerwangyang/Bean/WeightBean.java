package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 5/2/18.
 */

public class WeightBean {
    private int _id;
    private int type;
    private String map;

    @Override
    public String toString() {
        return "WeightBean{" +
                "_id=" + _id +
                ", type=" + type +
                ", map='" + map + '\'' +
                '}';
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
