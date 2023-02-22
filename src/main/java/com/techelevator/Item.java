package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

//This class is designed to get name and price for each item
    //Use getters and setters for name and price
    //Declare String variables for name and price
    private String name;
    private BigDecimal price;
    private String slotLocation;
    private String type;
    private int quantity;

    public Item(String name, BigDecimal price, String slotLocation, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        this.type = type;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getType() {
        return type;
    }

    public abstract String getMessage ();



}
