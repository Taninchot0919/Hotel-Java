package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<BookingDetail> bookingDetails = new ArrayList<>();

    public BookingController() {

        roomList.add(new Room("STD001", RoomType.STANDARD));
        roomList.add(new Room("STD002", RoomType.STANDARD));
        roomList.add(new Room("STD003", RoomType.STANDARD, new Customer("Taninchot", "095")));
        roomList.add(new Room("STD004", RoomType.STANDARD));
        roomList.add(new Room("STD005", RoomType.STANDARD));

        roomList.add(new Room("SUP001", RoomType.SUPERIOR, new Customer("Art", "098")));
        roomList.add(new Room("SUP002", RoomType.SUPERIOR));
        roomList.add(new Room("SUP003", RoomType.SUPERIOR));
        roomList.add(new Room("SUP004", RoomType.SUPERIOR));
        roomList.add(new Room("SUP005", RoomType.SUPERIOR));

        roomList.add(new Room("DEL001", RoomType.DELUXE));
        roomList.add(new Room("DEL002", RoomType.DELUXE));
        roomList.add(new Room("DEL003", RoomType.DELUXE));
        roomList.add(new Room("DEL004", RoomType.DELUXE, new Customer("4rTTh0", "095")));
        roomList.add(new Room("DEL005", RoomType.DELUXE));

        bookingDetails.add(new BookingDetail(roomList.get(2), new OptionOfRoom(3, true), "PENDING", 3));
        bookingDetails.add(new BookingDetail(roomList.get(5), new OptionOfRoom(3, true), "PENDING", 3));
        bookingDetails.add(new BookingDetail(roomList.get(13), new OptionOfRoom(2, false), "PENDING", 5));
    }

    public void showAllRoom() {
        for (Room room : roomList) {
            System.out.println(room);
        }
    }

    public void checkout(String roomID) {
        int indexOfBooking = findBookingDetailByRoomID(roomID, true);
        if (indexOfBooking == -1) {
            System.out.println("Can't Checkout cannot find roomID or Room doesn't booking");
            return;
        }
        Room room = bookingDetails.get(indexOfBooking).getRoom();
        room.setRoomStatus(RoomStatus.AVAILABLE);
        room.setCustomer(null);
        bookingDetails.remove(indexOfBooking);
        System.out.println("Checkout Successfully");

    }

    public void showRoomType(RoomType roomType) {
        List<Room> rooms = roomList.stream().filter(room -> room.getRoomType().equals(roomType)).collect(Collectors.toList());
        rooms.forEach(room -> {
            System.out.println(room);
        });
    }

    public void showRoomAvailable(RoomStatus roomStatus) {
        List<Room> rooms = roomList.stream().filter(room -> room.getRoomStatus().equals(roomStatus)).collect(Collectors.toList());
        rooms.forEach(room -> {
            System.out.println(room);
        });
    }

    public void booking(String customerName, String customerTelNo, int roomIndex, int numberOfPeople, int extendBed, String breakfastPackage) {
        Customer customer = new Customer(customerName, customerTelNo);
        boolean isHavePackage = false;
        if (breakfastPackage.equals("Y")) {
            isHavePackage = true;
        }

        if (breakfastPackage.equals("N")) {
            isHavePackage = false;
        }
        Room room = roomList.get(roomIndex);
        room.setCustomer(customer);
        room.setRoomStatus(RoomStatus.NOT_AVAILABLE);
        OptionOfRoom optionOfRoom = new OptionOfRoom(extendBed, isHavePackage);
        System.out.println("The Price is : " + calBookingPrice(room, numberOfPeople, extendBed, isHavePackage));
        bookingDetails.add(new BookingDetail(
                room,
                optionOfRoom,
                "PENDING",
                numberOfPeople));
        bookingDetails.stream().filter(item -> item.getRoom().equals(room));
        return;
    }

    public void showBookingDetails() {
        bookingDetails.forEach(item -> {
            System.out.println(item);
        });
    }

    public double calBookingPrice(Room room, int numberOfPeople, int extendBed, boolean breakfastPackage) {
        double price = 0;
        double bedPrice = 0;
        double breakfastPrice = 0;
        price += room.getRoomPrice();

        if (extendBed != 0) {
            bedPrice = 1500 * extendBed;
        }
        price += bedPrice;

        if (numberOfPeople != 0 && breakfastPackage) {
            breakfastPrice = 2500 * numberOfPeople;
        }

        price += breakfastPrice;
        return price;
    }

    public int findByRoomIDAndCanBooking(String roomID) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            if (room.getRoomID().equals(roomID) && room.getRoomStatus().equals(RoomStatus.AVAILABLE)) {
                return i;
            }
        }
        return -1;
    }

    public int findBookingDetailByRoomID(String roomID, boolean isCheckout) {
        if (isCheckout == false) {
            for (int i = 0; i < bookingDetails.size(); i++) {
                BookingDetail detailOfBooking = bookingDetails.get(i);
                if (detailOfBooking.getRoom().getRoomID().equals(roomID)) {
                    return i;
                }
            }
        }
        if (isCheckout == true) {
            for (int i = 0; i < bookingDetails.size(); i++) {
                BookingDetail detailOfBooking = bookingDetails.get(i);
                if (detailOfBooking.getRoom().getRoomID().equals(roomID) && detailOfBooking.getRoom().getRoomStatus().equals(RoomStatus.NOT_AVAILABLE)) {
                    return i;
                }
            }
        }

        return -1;
    }

}
