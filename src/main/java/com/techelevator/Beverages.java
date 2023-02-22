package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Item {

    public Beverages(String name, BigDecimal price, String slotLocation, String type, int quantity) {
        super(name, price, slotLocation, type, quantity);
    }

    public String getMessage() {
        return "Glug Glug, Chug Chug!";

    }
}
