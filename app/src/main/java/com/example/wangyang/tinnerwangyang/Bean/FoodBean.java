package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 31/1/18.
 */

public class FoodBean {
    private int _id;
    private String MorningFoodName;
    private int MorningWeight;
    private int MorningCalorie;

    @Override
    public String toString() {
        return "FoodBean{" +
                "_id=" + _id +
                ", MorningFoodName='" + MorningFoodName + '\'' +
                ", MorningWeight=" + MorningWeight +
                ", MorningCalorie=" + MorningCalorie +
                '}';
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
}

