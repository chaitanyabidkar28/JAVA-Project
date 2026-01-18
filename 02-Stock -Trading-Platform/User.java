package com.cb;

import java.util.*;
import java.io.*;

class User {
    String name;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.symbol,
                    portfolio.getOrDefault(stock.symbol, 0) + quantity);
            transactions.add(new Transaction(stock.symbol, quantity, stock.price, "BUY"));
            System.out.println("Stock purchased successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void sellStock(Stock stock, int quantity) {
        int owned = portfolio.getOrDefault(stock.symbol, 0);
        if (owned >= quantity) {
            balance += stock.price * quantity;
            portfolio.put(stock.symbol, owned - quantity);
            transactions.add(new Transaction(stock.symbol, quantity, stock.price, "SELL"));
            System.out.println("Stock sold successfully.");
        } else {
            System.out.println("Not enough shares.");
        }
    }

    void displayPortfolio() {
        System.out.println("\n--- Portfolio ---");
        System.out.println("Balance: $" + balance);
        for (String s : portfolio.keySet()) {
            System.out.println(s + ": " + portfolio.get(s) + " shares");
        }
    }

    void savePortfolio() throws IOException {
        FileWriter fw = new FileWriter("portfolio.txt");
        fw.write(name + "\n" + balance + "\n");
        for (String s : portfolio.keySet()) {
            fw.write(s + "," + portfolio.get(s) + "\n");
        }
        fw.close();
    }
}

