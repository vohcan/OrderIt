package com.vohcan.orderit.model;


import android.view.View;



public class Dish  {

    private static final String JSON_URL = "http://www.mocky.io/v2/5872afbe0f00008919c6acaf";

    private String mName;
    private String mDescription;
    private double mPrice;
    private int mDishImage;
    private int mAlergen1;
    private int mAlergen2;
    private int mAlergen3;


    //constructor


    public Dish(String name, String description, double price, int dishImage, int alergen1, int alergen2, int alergen3) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mDishImage = dishImage;
        mAlergen1 = alergen1;
        mAlergen2 = alergen2;
        mAlergen3 = alergen3;
    }


    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getPrice() {
        return mPrice;
    }

    public int getDishImage() {
        return mDishImage;
    }

    public int getAlergen1() {
        return mAlergen1;
    }

    public int getAlergen2() {
        return mAlergen2;
    }

    public int getAlergen3() {
        return mAlergen3;
    }




}
