package com.learning.demo.validator;

import com.learning.demo.dto.FlightBookingDto;

public interface FlightInputValidator {
    boolean validate(FlightBookingDto flightBookingDto);
}

