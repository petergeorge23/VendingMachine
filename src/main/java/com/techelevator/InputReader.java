package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InputReader {
    private static final int MAX_INVENTORY_PER_ITEM = 5;

    public Map<String, Item> makeMap() {
        File vendingMachineItems = new File("vendingmachine.csv");

        //instantiate map
        Map<String, Item> inventory = new TreeMap<>();
        try (Scanner inventoryScanner = new Scanner(vendingMachineItems)) {

            while (inventoryScanner.hasNextLine()) {
                String line = inventoryScanner.nextLine();
                //populate array
                String[] itemInventory = line.split("\\|");
                String slot = itemInventory[0];
                String name = itemInventory[1];
                String strPrice = itemInventory[2];
                String type = itemInventory[3];
                BigDecimal price = new BigDecimal(strPrice);

                //populate map
                switch (type) {
                    case "Chip" :
                        Chips chip = new Chips(name, price, slot, type, MAX_INVENTORY_PER_ITEM);
                        inventory.put(slot, chip);
                        break;
                    case "Candy" :
                        Candy candy = new Candy(name, price, slot, type,MAX_INVENTORY_PER_ITEM);
                        inventory.put(slot, candy);
                        break;
                    case "Drink" :
                        Beverages beverages = new Beverages(name, price, slot, type,MAX_INVENTORY_PER_ITEM);
                        inventory.put(slot, beverages);
                        break;
                    case "Gum" :
                        Gum gum = new Gum(name, price, slot, type, MAX_INVENTORY_PER_ITEM);
                        inventory.put(slot, gum);
                        break;
                    default :
                        break;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
        }

//        for(Map.Entry <String, Item> x: inventory.entrySet()){
//            System.out.printf("%-5s %-20s %-15s \n",x.getKey(), x.getValue().getName(), x.getValue().getPrice());
//        }

        return inventory;
    }
}








