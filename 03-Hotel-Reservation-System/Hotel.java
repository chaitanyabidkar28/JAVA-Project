package com.cb;

import java.util.*;
import java.io.*;

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();

    Hotel() {
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Standard", 2000));
        rooms.add(new Room(201, "Deluxe", 3500));
        rooms.add(new Room(301, "Suite", 5000));
        loadReservations();
    }

    void searchRooms(String category) {
        System.out.println("\nAvailable " + category + " Rooms:");
        for (Room r : rooms) {
            if (r.category.equalsIgnoreCase(category) && r.isAvailable) {
                System.out.println("Room " + r.roomNumber + " - ₹" + r.price);
            }
        }
    }

    void bookRoom(String name, String category) {
        for (Room r : rooms) {
            if (r.category.equalsIgnoreCase(category) && r.isAvailable) {
                r.isAvailable = false;
                Reservation res = new Reservation(name, r.roomNumber, category, r.price);
                reservations.add(res);
                saveReservations();
                System.out.println("Payment Successful!");
                System.out.println("Room Booked: " + r.roomNumber);
                return;
            }
        }
        System.out.println("No rooms available in this category.");
    }

    void cancelReservation(int roomNumber) {
        Iterator<Reservation> it = reservations.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.roomNumber == roomNumber) {
                it.remove();
                for (Room room : rooms) {
                    if (room.roomNumber == roomNumber)
                        room.isAvailable = true;
                }
                saveReservations();
                System.out.println("Reservation canceled. Refund processed.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    void viewBookings() {
        System.out.println("\n--- Booking Details ---");
        for (Reservation r : reservations) {
            System.out.println("Name: " + r.customerName +
                    " | Room: " + r.roomNumber +
                    " | Category: " + r.category +
                    " | Paid: ₹" + r.amountPaid);
        }
    }

    void saveReservations() {
        try {
            FileWriter fw = new FileWriter("bookings.txt");
            for (Reservation r : reservations) {
                fw.write(r.customerName + "," + r.roomNumber + "," +
                        r.category + "," + r.amountPaid + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving reservations.");
        }
    }

    void loadReservations() {
        try {
            File file = new File("bookings.txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                Reservation r = new Reservation(
                        data[0],
                        Integer.parseInt(data[1]),
                        data[2],
                        Double.parseDouble(data[3])
                );
                reservations.add(r);
                for (Room room : rooms) {
                    if (room.roomNumber == r.roomNumber)
                        room.isAvailable = false;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading reservations.");
        }
    }
}

