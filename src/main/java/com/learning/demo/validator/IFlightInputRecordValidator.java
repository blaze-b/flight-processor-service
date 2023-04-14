package com.learning.demo.validator;

import java.time.LocalDate;

/**
 * The interface Flight input record validator.
 */
public interface IFlightInputRecordValidator {

    /**
     * Is valid email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    boolean isValidEmail(String email);

    /**
     * Is valid mobile boolean.
     *
     * @param mobileNumber the mobile number
     * @return the boolean
     */
    boolean isValidMobile(String mobileNumber);

    /**
     * Is valid ticketing date boolean.
     *
     * @param ticketingDate the ticketing date
     * @param travelDate    the travel date
     * @return the boolean
     */
    boolean isValidTicketingDate(String ticketingDate, String travelDate);

    /**
     * Is valid ticketing date boolean.
     *
     * @param ticketingDate the ticketing date
     * @param travelDate    the travel date
     * @return the boolean
     */
    boolean isValidTicketingDate(LocalDate ticketingDate, LocalDate travelDate);

    /**
     * Is valid pnr boolean.
     *
     * @param pnr the pnr
     * @return the boolean
     */
    boolean isValidPnr(String pnr);

    /**
     * Is valid booked cabin boolean.
     *
     * @param cabin the cabin
     * @return the boolean
     */
    boolean isValidBookedCabin(String cabin);

}

