package com.learning.demo.validator;

import com.learning.demo.dto.FlightBookingDto;

import java.util.Objects;

public class FlightEmailInputValidator implements FlightInputValidator {
    @Override
    public boolean validate(FlightBookingDto inputRecord) {
        String email = inputRecord.getEmail();
        return Objects.nonNull(email) && email.contains("@");
    }
}
