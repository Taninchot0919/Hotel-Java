package view;

import controller.BookingController;
import model.RoomStatus;
import model.RoomType;

import java.util.Scanner;

public class BookingView {
    private BookingController bookingController = new BookingController();

    public void runProgram() {
        boolean isProgramEnding = false;
        while (!isProgramEnding) {
            Scanner sc = new Scanner(System.in);
            showMainMenu();
            int numberSelected = sc.nextInt();
            switch (numberSelected) {
                case 1:
                    bookingController.showAllRoom();
                    break;
                case 2:
                    showByRoomTypeMenu();
                    break;
                case 3:
                    bookingController.showRoomAvailable(RoomStatus.AVAILABLE);
                    break;
                case 4:
                    booking();
                    break;
                case 5:
                    bookingController.showBookingDetails();
                    break;
                case 0:
                    isProgramEnding = true;
                    break;
            }
        }
        System.out.println("Exiting Program ...");
    }

    public void showMainMenu() {
        System.out.println("");
        System.out.println("1. Show All rooms");
        System.out.println("2. Show By room types");
        System.out.println("3. Show Room Available");
        System.out.println("4. Booking");
        System.out.println("5. Show Booking Details");
        System.out.println("0. Exit Program");
        System.out.print("You selected : ");
    }

    public void showByRoomTypeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("1. Standard Rooms");
        System.out.println("2. Superior Rooms");
        System.out.println("3. Deluxe Rooms");
        System.out.println("0. Back");
        System.out.print("You selected : ");
        int selectedNumber = sc.nextInt();
        showRoomByType(selectedNumber);
    }

    public void showRoomByType(int number) {
        switch (number) {
            case 1:
                bookingController.showRoomType(RoomType.STANDARD);
                break;
            case 2:
                bookingController.showRoomType(RoomType.SUPERIOR);
                break;
            case 3:
                bookingController.showRoomType(RoomType.DELUXE);
                break;
        }
    }

    public void booking() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Customer Name : ");
        String name = sc.nextLine();

        System.out.print("Customer TelNo. : ");
        String telNo = sc.nextLine();

        showByRoomTypeMenu();

        System.out.print("Selected Room : ");
        String roomID = sc.nextLine();

        System.out.print("Number of people : ");
        Scanner sc2 = new Scanner(System.in);
        int numberOfPeople = sc2.nextInt();

        System.out.print("Extend Bed If not [0]: ");
        int extendBed = sc2.nextInt();

        System.out.print("Breakfast Package [Y:N] : ");
        String breakfastPackage = sc.nextLine();
        bookingController.booking(name, telNo, roomID, numberOfPeople, extendBed, breakfastPackage);
    }

}
