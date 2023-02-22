package com.techelevator;

import java.math.BigDecimal;
import java.util.Locale;

public class Coinbox {
    // Feed money into the vending machine
    //VendingMachineCLI vendingMachine = new VendingMachineCLI();

    private BigDecimal currentMoney;
    private final int QUARTER = 25;
    private final int DIME = 10;
    private final int NICKEL = 5;


    public Coinbox(){
        currentMoney = new BigDecimal("0.00");
    }
    public BigDecimal getCurrentMoney(){
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal feedMoney(int amount) {
        BigDecimal insertedAmount = new BigDecimal(amount + ".00");
        currentMoney = currentMoney.add(insertedAmount);
        System.out.println("$" + insertedAmount + " has been inserted.");
        return currentMoney;
    }

    public BigDecimal takeChange(int amount){
        BigDecimal acceptedAmount = new BigDecimal(amount +".00");
        if(acceptedAmount.compareTo(currentMoney)>0){
            System.out.println("Error: There is not enough money available for change.");
            return new BigDecimal("0.00");
        }else {
            currentMoney = currentMoney.subtract(acceptedAmount);
            System.out.println("$" + acceptedAmount + "has been accepted as change.");
            return acceptedAmount;
        }
    }

    public void getChange (VendingMachineCLI cli) {
        BigDecimal multiplyByHundred = cli.coinbox.getCurrentMoney().multiply(BigDecimal.valueOf(100.0));
        int currentBalance = multiplyByHundred.intValue();
       // int currentBalance = cli.coinbox.getCurrentMoney().intValue() * 100;
        int numOfQuarters = (int)currentBalance/QUARTER;
        currentBalance = currentBalance % QUARTER;
        int numberOfDimes = (int) (currentBalance/DIME);
        currentBalance =  currentBalance % DIME;
        int numberOfNickels = (int) (currentBalance/NICKEL);
        currentBalance = currentBalance % NICKEL;
        System.out.println("Here is your change: " + numOfQuarters + " Quarters " + numberOfDimes + " Dimes " + numberOfNickels + " Nickels ");


    }

   /* public BigDecimal returnChange (VendingMachineCLI cli){
        while(!currentMoney.equals(0)){
            if (cli.coinbox.getCurrentMoney().divideAndRemainder(BigDecimal.valueOf(.25));
        }
        BigDecimal change = currentMoney;
        currentMoney = new BigDecimal("0.00");
        System.out.println("$" + change +"has been returned as change.");
        return change;
    }*/

    public void dispenseItem(VendingMachineCLI cli, String slotChoice) {
        // Purpose: Checks to see if it's a valid transaction
        // If so, gives item (removes 1 from its quantity) and tells user they got the item
        // Subtracts the price from currentMoney
        Item selectedItem = cli.inventory.get(slotChoice.toUpperCase());//fix case-sensitive

        // Checks to see if inventory of item is not sold out
        if (selectedItem.getQuantity() > 0) {
            if (cli.coinbox.getCurrentMoney().compareTo(selectedItem.getPrice()) >= 0) {
                selectedItem.setQuantity(selectedItem.getQuantity() -1);
                cli.coinbox.setCurrentMoney(getCurrentMoney().subtract(selectedItem.getPrice()));
                System.out.println("Here's your " + cli.inventory.get(slotChoice).getName() + ": " + cli.inventory.get(slotChoice).getMessage());
            }else {
                System.out.println("Sorry, you have insufficient funds!");
            }
        } else {
            System.out.println("The item is sold out!");
        }
    }
}


