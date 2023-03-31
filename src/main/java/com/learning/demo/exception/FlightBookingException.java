package com.learning.demo.exception;

/**
 * The type Flight booking exception.
 */
public class FlightBookingException extends Exception {

    /**
     * Instantiates a new Flight booking exception.
     *
     * @param message the message
     */
    public FlightBookingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Flight booking exception.
     *
     * @param message   the message
     * @param throwable the throwable
     */
    public FlightBookingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
