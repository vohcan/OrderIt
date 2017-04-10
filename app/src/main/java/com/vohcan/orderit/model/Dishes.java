package com.vohcan.orderit.model;

import java.util.List;

public class Dishes {
    private static List<Dish> sDishes;

    public static List<Dish> getDishes() {
        return sDishes;
    }

    public static void setDishes(List<Dish> dishes) {
        sDishes = dishes;
    }
}