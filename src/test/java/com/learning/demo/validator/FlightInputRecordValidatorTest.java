package com.learning.demo.validator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FlightInputRecordValidatorTest {

    private IFlightInputRecordValidator iFlightInputRecordValidator;

    @Before
    public void init() {
        iFlightInputRecordValidator = new FlightInputRecordValidator();
    }

    @Test
    public void isValidEmail_ValidEmailTest() {
        String email = "test@test.com";

        boolean isValid = iFlightInputRecordValidator.isValidEmail(email);

        Assertions.assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void isValidEmail_InValidEmailTest() {
        String email = "testtest.com";

        boolean isValid = iFlightInputRecordValidator.isValidEmail(email);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidEmail_NullEmailTest() {
        boolean isValid = iFlightInputRecordValidator.isValidEmail(null);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidMobile_ValidMobileTest() {
        String mobileNumber = "1234567890";

        boolean isValid = iFlightInputRecordValidator.isValidMobile(mobileNumber);

        Assertions.assertThat(isValid).isEqualTo(true);
    }


    @Test
    public void isValidMobile_InValidMobileTest() {
        String mobileNumber = "abcdefghij";

        boolean isValid = iFlightInputRecordValidator.isValidMobile(mobileNumber);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidMobile_NullMobileTest() {
        boolean isValid = iFlightInputRecordValidator.isValidMobile(null);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidTicketingDate_ValidScenarioTest() {
        String ticketingDate = "2019-05-21";
        String travelDate = "2019-07-31";

        boolean isValid = iFlightInputRecordValidator.isValidTicketingDate(ticketingDate, travelDate);

        Assertions.assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void isValidTicketingDate_InValidScenarioTest() {
        String ticketingDate = "2019-07-31";
        String travelDate = "2019-05-21";

        boolean isValid = iFlightInputRecordValidator.isValidTicketingDate(ticketingDate, travelDate);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidTicketingDate_NullValueScenarioTest() {
        boolean isValid = iFlightInputRecordValidator.isValidTicketingDate(null, null);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidTicketingDate_InvalidDateScenarioTest() {
        boolean isValid = iFlightInputRecordValidator.isValidTicketingDate("7878", "weere");

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidPnr_ValidTest() {
        String pnr = "ABC123";

        boolean isValid = iFlightInputRecordValidator.isValidPnr(pnr);

        Assertions.assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void isValidPnr_LessThanSixTest() {
        String pnr = "ABC12";

        boolean isValid = iFlightInputRecordValidator.isValidPnr(pnr);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidPnr_AllAlphabetsTest() {
        String pnr = "ABC";

        boolean isValid = iFlightInputRecordValidator.isValidPnr(pnr);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidPnr_AllNumericTest() {
        String pnr = "12345";

        boolean isValid = iFlightInputRecordValidator.isValidPnr(pnr);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidPnr_NullTest() {
        boolean isValid = iFlightInputRecordValidator.isValidPnr(null);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidBookedCabin_ValidTest() {
        String cabin = "Economy";

        boolean isValid = iFlightInputRecordValidator.isValidBookedCabin(cabin);

        Assertions.assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void isValidBookedCabin_CaseInsensitiveTest() {
        String cabin = "economy";

        boolean isValid = iFlightInputRecordValidator.isValidBookedCabin(cabin);

        Assertions.assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void isValidBookedCabin_NotValidCabinTest() {
        String cabin = "economy1";

        boolean isValid = iFlightInputRecordValidator.isValidBookedCabin(cabin);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void isValidBookedCabin_NullCabinTest() {
        boolean isValid = iFlightInputRecordValidator.isValidBookedCabin(null);

        Assertions.assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void validateCsvRecord_ValidScenarioTest() {
        String recordDetail = "Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com, 9876543210,Economy";
        String[] record = recordDetail.split(",");

        FlightInputRecordValidator flightInputRecordValidator = (FlightInputRecordValidator) iFlightInputRecordValidator;

        boolean isValid = flightInputRecordValidator.validateCsvRecord(record);

        Assertions.assertThat(isValid).isEqualTo(true);

    }

    @Test
    public void validateCsvRecord_InValidEmailMobileScenarioTest() {
        String recordDetail = "Abhishek,Kumar,ABC12,F,2019-07-31,2,2020-05-21,abhishekzzz.com, 987654321,Economy1";
        String[] record = recordDetail.split(",");

        FlightInputRecordValidator flightInputRecordValidator = (FlightInputRecordValidator) iFlightInputRecordValidator;

        boolean isValid = flightInputRecordValidator.validateCsvRecord(record);

        Assertions.assertThat(isValid).isEqualTo(false);

    }
}
