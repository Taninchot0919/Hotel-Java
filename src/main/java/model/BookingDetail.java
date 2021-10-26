package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetail {
    private Customer customer;
    private Room room;
    private OptionOfRoom optionOfRoom;
    private Date bookingDate;
    private boolean bookingStatus;
    private int numberOfPeople;
}
