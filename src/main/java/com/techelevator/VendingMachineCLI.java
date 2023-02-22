package com.techelevator;

import com.techelevator.view.VendingMenu;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private VendingMenu menu;

    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }

    InputReader choiceMenu = new InputReader();
    Coinbox coinbox = new Coinbox();
    Scanner userInput = new Scanner(System.in);
    Map<String, Item> inventory = choiceMenu.makeMap();

    public void run() {
        boolean running = true;
        while (running) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                displayInventory(inventory);
            }

            if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

                boolean isInPurchaseMenu = true;
                while (isInPurchaseMenu) {

                    String secondChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    // boolean isFeedMoney = true;
                    // while (isFeedMoney) {
                    if (secondChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        // Trying to call on Coinbox and get feedMoney method
                        System.out.println("Please enter a whole dollar amount: $1, $5, $10");
                        int feedUserInput = Integer.parseInt(userInput.nextLine());
                        coinbox.feedMoney(feedUserInput);
                        System.out.println("Current Money Inserted: " + coinbox.getCurrentMoney());
                    }

                    if (secondChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        displayInventory(inventory);
                        System.out.println("Please select a slot. (ie A1, A2)");
                        String slotChoice = userInput.nextLine();

                        coinbox.dispenseItem(this, slotChoice);
                        //System.out.println("Here's your " + inventory.get(slotChoice).getName() + ": " + inventory.get(slotChoice).getMessage());
                    }

                    if (secondChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        coinbox.getChange(this);
                        isInPurchaseMenu = false;
                    }
                }
            }

            if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                running = false;
            }

            if (choice.equals(MAIN_MENU_SECRET_OPTION)) {
                //System.out.println("To Do");
            }
        }
    }

    public static void main(String[] args) {
        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void displayInventory(Map<String, Item> inventoryMap) {
        for (Map.Entry<String, Item> entry : inventoryMap.entrySet()) {
            // A1: Crisps 3.50 Amount Remaining: 5
            String slot = entry.getKey();
            String itemName = entry.getValue().getName();
            BigDecimal price = entry.getValue().getPrice();
            int quantity = entry.getValue().getQuantity();

            System.out.println(slot + ": " + itemName + " " + price + " Amount Remaining: " + quantity);
        }
    }
}