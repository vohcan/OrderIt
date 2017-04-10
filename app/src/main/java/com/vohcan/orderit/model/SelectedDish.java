package com.vohcan.orderit.model;

import java.util.LinkedList;

/**
 * Created by vohcan on 23/1/17.
 */

public class SelectedDish {

    private String nameSelected;
    private double priceSelected;
    private int imageSelected;
    private String complementSelected;
    private LinkedList<Dish> selectedDishes;


    public SelectedDish(String nameSelected, double priceSelected, int imageSelected, String complementSelected) {
        this.nameSelected = nameSelected;
        this.priceSelected = priceSelected;
        this.imageSelected = imageSelected;
        this.complementSelected = complementSelected;
    }

    public String getNameSelected() {
        return nameSelected;
    }

    public void setNameSelected(String nameSelected) {
        this.nameSelected = nameSelected;
    }

    public double getPriceSelected() {
        return priceSelected;
    }

    public void setPriceSelected(double priceSelected) {
        this.priceSelected = priceSelected;
    }

    public int getImageSelected() {
        return imageSelected;
    }

    public void setImageSelected(int imageSelected) {
        this.imageSelected = imageSelected;
    }

    public String getComplementSelected() {
        return complementSelected;
    }

    public void setComplementSelected(String complementSelected) {
        this.complementSelected = complementSelected;
    }

    public double getBill(){
        double total = 0.0;
        for (int i = 0; i< selectedDishes.size();i++){
            total += selectedDishes.get(i).getPrice();
        }
        return total;
    }
}
