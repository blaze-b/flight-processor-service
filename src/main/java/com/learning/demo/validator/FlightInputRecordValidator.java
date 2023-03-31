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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Flight input record validator.
 */
@Getter
public class FlightInputRecordValidator implements IFlightInputRecordValidator {

    private static final Logger log = LogManager.getLogger();
    private static final String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private List<String> errorDetails;

    @Override
    public boolean isValidEmail(String email) {
        if(Objects.isNull(email))
            return false;
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean isValidMobile(String mobileNumber) {
        return Objects.nonNull(mobileNumber) && mobileNumber.matches("^\\d{10}$");
    }

    @Override
    public boolean isValidTicketingDate(String ticketingDate, String travelDate) {
        try {
            LocalDate ticketingDateAfterParsing = LocalDate.parse(ticketingDate);
            LocalDate travelDateAfterParsing = LocalDate.parse(travelDate);
            return ticketingDateAfterParsing.isBefore(travelDateAfterParsing);
        } catch (DateTimeParseException | NullPointerException e) {
            log.error("isValidTicketingDate::error-details::{}", e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean isValidPnr(String pnr) {
        return Objects.nonNull(pnr) && pnr.matches("^[a-zA-Z0-9]{6}$");
    }

    @Override
    public boolean isValidBookedCabin(String cabin) {
        return Objects.nonNull(cabin) && Cabin.containsCabin(cabin);
    }

    /**
     * Validate csv record boolean.
     *
     * @param record the record
     * @return the boolean
     */
    public boolean validateCsvRecord(String[] record) {
        boolean isValid = true;
        errorDetails = new ArrayList<>();
        if (!isValidEmail(record[7].trim())) {
            errorDetails.add("Email Id Invalid");
            isValid = false;
        }
        if (!isValidMobile(record[8].trim())) {
            errorDetails.add("Mobile Number Invalid");
            isValid = false;
        }
        if (!isValidTicketingDate(record[6].trim(), record[4].trim())) {
            errorDetails.add("Ticketing date is before travel date");
            isValid = false;
        }
        if (!isValidPnr(record[2].trim())) {
            errorDetails.add("PNR should be 6 characters and also alpha numeric");
            isValid = false;
        }
        if (!isValidBookedCabin(record[9].trim())) {
            errorDetails.add("The booked cabin is not valid");
            isValid = false;
        }
        return isValid;
    }
}
