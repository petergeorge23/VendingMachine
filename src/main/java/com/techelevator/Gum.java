package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {
    public Gum(String name, BigDecimal price, String slotLocation, String type, int quantity) {
        super(name, price, slotLocation, type, quantity);
    }

    public String getMessage() {
        return "Chew Chew, Pop!";
    }
}
