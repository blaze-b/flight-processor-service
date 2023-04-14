package com.learning.demo.dto;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FlightBookingErrorDtoTest {

    private FlightBookingError flightBookingErrorDto;

    @Before
    public void init() {
        flightBookingErrorDto = new FlightBookingError();
    }

    @Test
    public void setFlightBookingDetails_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");

        flightBookingErrorDto.setFlightBookingDetails(record, Arrays.asList("Invalid Email", "PNR Issue"));

        Assertions.assertThat(flightBookingErrorDto.getErrorDetails()).isNotEmpty();
    }

    @Test
    public void toCsv_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");
        flightBookingErrorDto.setFlightBookingDetails(record);

        String csvRecord = flightBookingErrorDto.toCsv();

        Assertions.assertThat(csvRecord).isNotEmpty();
    }

    @Test
    public void toString_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");
        flightBookingErrorDto.setFlightBookingDetails(record);

        String flightDetails = flightBookingErrorDto.toString();

        Assertions.assertThat(flightDetails).isNotEmpty();
    }
}
