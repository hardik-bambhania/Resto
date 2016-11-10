package com.be.msu.resto.model;

import java.util.ArrayList;

public class Order {
    private int id;
    private int totalPrice;
    private String dateTime;
    private int numberOfItem;
    private boolean isVegetarian;
    private ArrayList<MenuItem> orderedItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public ArrayList<MenuItem> getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(ArrayList<MenuItem> mOrderedItem) {
        this.orderedItem = mOrderedItem;
    }
}
