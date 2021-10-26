package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Room {
    private String roomID;
    private double roomPrice;
    private Customer customer;
    private RoomType roomType;
    private RoomStatus roomStatus;

    public Room(String roomId, RoomType roomType) {
        this.roomID = roomId;
        this.roomType = roomType;
        roomStatus = RoomStatus.AVAILABLE;

        if (roomType.equals(RoomType.STANDARD)) {
            roomPrice = 1500;
        }
        if (roomType.equals(RoomType.SUPERIOR)) {
            roomPrice = 2900;
        }
        if (roomType.equals(RoomType.DELUXE)) {
            roomPrice = 5200;
        }
    }
}
