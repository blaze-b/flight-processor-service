package com.learning.demo.validator;

import com.learning.demo.constants.Cabin;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class FlightInputRecordValidator implements IFlightInputRecordValidator {

    private static final Logger log = LogManager.getLogger();

    private List<String> errorDetails;

    @Override
    public boolean isValidEmail(String email) {
        return Objects.nonNull(email) && email.contains("@");
    }

    @Override
    public boolean isValidMobile(String mobileNumber) {
        return Objects.nonNull(mobileNumber) && mobileNumber.matches("\\d{10}");
    }

    @Override
    public boolean isValidTicketingDate(String ticketingDate, String travelDate) {
        try {
            LocalDate ticketingDateAfterParsing = LocalDate.parse(ticketingDate);
            LocalDate travelDateAfterParsing = LocalDate.parse(travelDate);
            return ticketingDateAfterParsing.isBefore(travelDateAfterParsing);
        } catch (DateTimeParseException e) {
            log.error("isValidTicketingDate::error-details::{}", e.getLocalizedMessage(), e.getCause());
            return false;
        }
    }

    @Override
    public boolean isValidPnr(String pnr) {
        return Objects.nonNull(pnr) && pnr.matches("[a-zA-Z0-9]{6}");
    }

    @Override
    public boolean isValidBookedCabin(String cabin) {
        return Objects.nonNull(cabin) && Cabin.containsCabin(cabin);
    }

    public boolean validateCsvRecord(String[] record) {
        boolean isValid = true;
        errorDetails = new ArrayList<>();
        if (!isValidEmail(record[7])) {
            errorDetails.add("Email Id Invalid");
            isValid = false;
        }
        if (!isValidMobile(record[8])) {
            errorDetails.add("Mobile Number Invalid");
            isValid = false;
        }
        if (!isValidTicketingDate(record [6], record[4])) {
            errorDetails.add("Ticketing date is before travel date");
            isValid = false;
        }
        if (!isValidPnr(record[2])) {
            errorDetails.add("PNR should be 6 characters and also alpha numeric");
            isValid = false;
        }
        if (!isValidBookedCabin(record [9])) {
            errorDetails.add("The booked cabin is not valid");
            isValid = false;
        }
        return isValid;
    }
}
