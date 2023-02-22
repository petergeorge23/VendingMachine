package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item  {
    public Candy(String name, BigDecimal price, String slotLocation, String type, int quantity) {
        super(name, price, slotLocation, type, quantity);
    }

    public String getMessage() {
        return "Munch Munch, Mmm Mmm Good!";
    }

}
