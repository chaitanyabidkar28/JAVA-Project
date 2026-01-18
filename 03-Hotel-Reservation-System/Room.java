package com.cb;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
}

