package com.learning.demo.exception;

public class FlightBookingException extends Exception {

    public FlightBookingException(String message) {
        super(message);
    }

    public FlightBookingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
