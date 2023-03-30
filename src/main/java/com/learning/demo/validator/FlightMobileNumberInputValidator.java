package com.learning.demo.validator;

import com.learning.demo.dto.FlightBookingDto;

import java.util.Objects;

public class FlightMobileNumberInputValidator implements FlightInputValidator {
    @Override
    public boolean validate(FlightBookingDto flightBookingDto) {
        String mobilePhone = flightBookingDto.getMobilePhone();
        return Objects.nonNull(mobilePhone) && mobilePhone.matches("\\d{10}");
    }
}
