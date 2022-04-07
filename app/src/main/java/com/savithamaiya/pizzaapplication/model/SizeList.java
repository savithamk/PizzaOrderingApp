package com.savithamaiya.pizzaapplication.model;

public class SizeList {
    String name;
    Double price;
    Boolean isSelected = false;

    public SizeList(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
