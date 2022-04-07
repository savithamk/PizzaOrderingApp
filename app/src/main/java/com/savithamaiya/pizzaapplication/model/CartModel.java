package com.savithamaiya.pizzaapplication.model;

import java.util.HashSet;

public class CartModel {
    String name;
    int image;
    int qty=1;
    double price;
    double extraPrice;
    HashSet<String> items = new HashSet<>();

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HashSet<String> getItems() {
        return items;
    }

    public void setItems(HashSet<String> items) {
        this.items = items;
    }
}
