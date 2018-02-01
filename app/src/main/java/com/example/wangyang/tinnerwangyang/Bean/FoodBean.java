package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 31/1/18.
 */

public class FoodBean implements Wachter {
    private int _id;
    private String MorningFoodName;
    private int MorningWeight;
    private int MorningCalorie;
    private int type;

    @Override
    public String toString() {
        return "FoodBean{" +
                "_id=" + _id +
                ", MorningFoodName='" + MorningFoodName + '\'' +
                ", MorningWeight=" + MorningWeight +
                ", MorningCalorie=" + MorningCalorie +
                ", type=" + type +
                '}';
    }

    public void setType(int type) {
        this.type = type;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getMorningFoodName() {
        return MorningFoodName;
    }

    public void setMorningFoodName(String morningFoodName) {
        MorningFoodName = morningFoodName;
    }

    public int getMorningWeight() {
        return MorningWeight;
    }

    public void setMorningWeight(int morningWeight) {
        MorningWeight = morningWeight;
    }

    public int getMorningCalorie() {
        return MorningCalorie;
    }

    public void setMorningCalorie(int morningCalorie) {
        MorningCalorie = morningCalorie;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    public int getfoodType() {
        return type;
    }

    @Override
    public String getType() {
        return null;
    }
}

