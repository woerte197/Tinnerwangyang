package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 2/2/18.
 */

public class Background implements Wachter {
    private int thistype;

    public Background(int type) {
        this.thistype = type;
    }

    public int getThistype() {
        return thistype;
    }

    public void setThistype(int thistype) {
        this.thistype = thistype;
    }

    @Override
    public String toString() {
        return "Background{" +
                "thistype=" + thistype +
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
