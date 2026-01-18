package com.cb;

import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    hotel.searchRooms(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Room Category: ");
                    hotel.bookRoom(name, sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    hotel.cancelReservation(sc.nextInt());
                    break;

                case 4:
                    hotel.viewBookings();
                    break;

                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    sc.close();
                    return;
            }
        }
    }
}

