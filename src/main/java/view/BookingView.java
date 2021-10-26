package view;

import controller.BookingController;
import model.Room;
import model.RoomType;

import java.util.ArrayList;

public class BookingView {
    private ArrayList<Room> room = new ArrayList<>();
    private BookingController bookingController = new BookingController();

    public BookingView() {

        room.add(new Room("STD001", RoomType.STANDARD));
        room.add(new Room("STD002", RoomType.STANDARD));
        room.add(new Room("STD003", RoomType.STANDARD));
        room.add(new Room("STD004", RoomType.STANDARD));
        room.add(new Room("STD005", RoomType.STANDARD));

        room.add(new Room("SUP001", RoomType.SUPERIOR));
        room.add(new Room("SUP002", RoomType.SUPERIOR));
        room.add(new Room("SUP003", RoomType.SUPERIOR));
        room.add(new Room("SUP004", RoomType.SUPERIOR));
        room.add(new Room("SUP005", RoomType.SUPERIOR));

        room.add(new Room("DEL001", RoomType.DELUXE));
        room.add(new Room("DEL002", RoomType.DELUXE));
        room.add(new Room("DEL003", RoomType.DELUXE));
        room.add(new Room("DEL004", RoomType.DELUXE));
        room.add(new Room("DEL005", RoomType.DELUXE));

    }

    public void getAllRoom() {
        bookingController.showAllRoom(room);
    }
}
