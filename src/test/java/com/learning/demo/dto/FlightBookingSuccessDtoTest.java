package com.learning.demo.dto;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FlightBookingSuccessDtoTest {

    private FlightBookingSuccessDto flightBookingSuccessDto;

    @Before
    public void init() {
        flightBookingSuccessDto = new FlightBookingSuccessDto();
    }

    @Test
    public void setFlightBookingDetails_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");

        flightBookingSuccessDto.setFlightBookingDetails(record);

        Assertions.assertThat(flightBookingSuccessDto.getDiscountCode()).isEqualTo("OFFER_30");
    }

    @Test
    public void toCsv_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");
        flightBookingSuccessDto.setFlightBookingDetails(record);

        String csvRecord = flightBookingSuccessDto.toCsv();

        Assertions.assertThat(csvRecord).isNotEmpty();
    }

    @Test
    public void toString_Test() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");
        flightBookingSuccessDto.setFlightBookingDetails(record);

        String flightDetails = flightBookingSuccessDto.toString();

        Assertions.assertThat(flightDetails).isNotEmpty();
    }
}
