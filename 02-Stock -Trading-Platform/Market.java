package com.cb;

import java.util.*;

class Market {
    ArrayList<Stock> stocks = new ArrayList<>();

    Market() {
        stocks.add(new Stock("AAPL", 180));
        stocks.add(new Stock("GOOG", 140));
        stocks.add(new Stock("TSLA", 250));
    }

    void displayMarket() {
        System.out.println("\n--- Market Data ---");
        for (Stock s : stocks) {
            System.out.println(s.symbol + " : $" + s.price);
        }
    }

    Stock getStock(String symbol) {
        for (Stock s : stocks) {
            if (s.symbol.equalsIgnoreCase(symbol))
                return s;
        }
        return null;
    }
}

