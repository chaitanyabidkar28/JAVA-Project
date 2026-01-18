package com.cb;

class Reservation {
    String customerName;
    int roomNumber;
    String category;
    double amountPaid;

    Reservation(String customerName, int roomNumber, String category, double amountPaid) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.amountPaid = amountPaid;
    }
}

