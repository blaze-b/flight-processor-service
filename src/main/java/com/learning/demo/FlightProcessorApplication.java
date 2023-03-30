package com.learning.demo;

import com.learning.demo.dto.FlightBookingDto;
import com.learning.demo.validator.FlightInputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlightProcessorApplication {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.info("flight-service-details-service-hello::entering......");
        FlightBookingDto flightBookingDto = new FlightBookingDto();
        flightBookingDto.setFirstName("Brian");
        flightBookingDto.setLastName("Blaze");
        flightBookingDto.setEmail("brian.blaze@gmail.com");
        log.info(flightBookingDto);
    }
}
