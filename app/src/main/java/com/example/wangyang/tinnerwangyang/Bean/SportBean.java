package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 5/2/18.
 */

public class SportBean implements Wachter {
    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    private String sportname;
    private int sporttime;
    private int sportCalorie;
    private int type;

    @Override
    public String toString() {
        return "SportBean{" +
                "sportname='" + sportname + '\'' +
                ", sporttime=" + sporttime +
                ", sportCalorie=" + sportCalorie +
                ", type=" + type +
                '}';
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }

    public int getSporttime() {
        return sporttime;
    }

    public void setSporttime(int sporttime) {
        this.sporttime = sporttime;
    }

    public int getSportCalorie() {
        return sportCalorie;
    }

    public void setSportCalorie(int sportCalorie) {
        this.sportCalorie = sportCalorie;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return null;
    }

    public int getSportType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
