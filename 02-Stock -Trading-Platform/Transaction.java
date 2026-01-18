package com.cb;

class Transaction {
    String stockSymbol;
    int quantity;
    double price;
    String type;

    Transaction(String stockSymbol, int quantity, double price, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }
}

