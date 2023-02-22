package com.techelevator;

import java.math.BigDecimal;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;
public class Logs {
    File log = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-3\\src\\main\\resources\\log.txt");

    boolean append = log.exists();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    String formatDateTime = now.format(formatter);

    public void feedMoneyLog(VendingMachineCLI cli) {
        BigDecimal moneyIn = cli.coinbox.feedMoney(cli.coinbox.feedMoney());
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, append))) {
            writer.println(formatDateTime);
            writer.println(moneyIn);
            writer.println(cli.coinbox.getCurrentMoney());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
        }
        //num of transactions
    }

    public void purchaseLog(VendingMachineCLI cli, String slotChoice) {
//        for(String key: vendingMachineCLI.inventory.keySet()){
//            if (key == slotChoice){
//                String productKey = key;
//
        //  FileOutputStream fw = new  FileWriter("log.txt",true);
        String productName = cli.inventory.get(slotChoice).getName();
        BigDecimal productPrice = cli.inventory.get(slotChoice).getPrice();
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
            writer.println(formatDateTime);
            writer.println(productName);
            writer.println(slotChoice);
            writer.println(productPrice);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
        }
    }


    public void noTransaction(VendingMachineCLI cli, String slotChoice) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, append))) {
            String curr_date = DateFormat.format(c.getTime());
            writer.println(curr_date);
            writer.println();
            writer.println(cli.coinbox.getCurrentMoney());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
        }
    }
}


//}
//
//
//    public void exitLog(VendingMachineCLI cli, String slotChoice) {
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, append))) {
//            String curr_date = DateFormat.format(c.getTime());
//            writer.println(curr_date);
//
//        }
//    }
////
//    public void salesLog(VendingMachineCLI cli, String slotChoice) {
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, append))) {
//            String curr_date = DateFormat.format(c.getTime());
//            writer.println(curr_date);
//
//        }
//    }
    //purchase log
    //feed money
    //item log




