package com.cb;

import java.util.Scanner;

public class StockTradingPlatform {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        User user = new User(name, 10000);

        while (true) {
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Save & Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                market.displayMarket();
            }
            else if (choice == 2) {
                System.out.print("Stock Symbol: ");
                String symbol = sc.next();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                Stock stock = market.getStock(symbol);
                if (stock != null) user.buyStock(stock, qty);
                else System.out.println("Stock not found.");
            }
            else if (choice == 3) {
                System.out.print("Stock Symbol: ");
                String symbol = sc.next();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                Stock stock = market.getStock(symbol);
                if (stock != null) user.sellStock(stock, qty);
                else System.out.println("Stock not found.");
            }
            else if (choice == 4) {
                user.displayPortfolio();
            }
            else if (choice == 5) {
                user.savePortfolio();
                System.out.println("Portfolio saved. Exiting...");
                break;
            }
        }
        sc.close();
    }
}
