package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {
    public Chips(String name, BigDecimal price, String slotLocation, String type, int quantity) {
        super(name, price, slotLocation, type, quantity);
    }

    public String getMessage() {
        return "Crunch Crunch, It's Yummy!";
    }
}
