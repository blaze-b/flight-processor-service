package com.learning.demo.validator;

public interface IFlightInputRecordValidator {
    boolean isValidEmail(String email);

    boolean isValidMobile(String mobileNumber);

    boolean isValidTicketingDate(String ticketingDate, String travelDate);

    boolean isValidPnr(String pnr);

    boolean isValidBookedCabin(String cabin);
}

