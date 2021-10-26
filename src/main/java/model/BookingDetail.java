package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetail {
    private Room room;
    private OptionOfRoom optionOfRoom;
    private String bookingStatus;
    private int numberOfPeople;
}
