package controller;

import model.Room;

import java.util.ArrayList;

public class BookingController {
    public void showAllRoom(ArrayList<Room> roomList) {
        for (Room room : roomList) {
            System.out.println(room);
        }
    }
}
