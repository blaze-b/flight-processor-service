package com.learning.demo.integration;

import com.learning.demo.exception.FlightBookingException;
import com.learning.demo.validator.FlightInputRecordValidator;
import com.learning.demo.validator.IFlightInputRecordValidator;
import org.junit.Before;
import org.junit.Test;

public class FlightInputRecordProcessorTest {

    private FlightFileRecordProcessor flightFileRecordProcessor;

    @Before
    public void init () {
        IFlightInputRecordValidator iFlightInputRecordValidator = new FlightInputRecordValidator();
        flightFileRecordProcessor = new FlightFileRecordProcessor(iFlightInputRecordValidator);
    }

    @Test
    public void processCsv_Test () throws FlightBookingException {
        String inputFile = "src/test/resources/input/input-test.csv";
        String outputValidFile = "output/output-success.csv";
        String outputFailureFile = "output/output-failure.csv";

        flightFileRecordProcessor.processCsv(inputFile, outputValidFile, outputFailureFile);
    }


    @Test
    public void processCsv_DefaultConstructorTest () throws FlightBookingException {
        String inputFile = "src/test/resources/input/input-test.csv";
        String outputValidFile = "output/output-success.csv";
        String outputFailureFile = "output/output-failure.csv";

        flightFileRecordProcessor = new FlightFileRecordProcessor();

        flightFileRecordProcessor.processCsv(inputFile, outputValidFile, outputFailureFile);
    }


    @Test(expected = FlightBookingException.class)
    public void processCsv_InvalidFileTest () throws FlightBookingException {
        String inputFile = "src/test/resources/input/input-test1.csv";
        String outputValidFile = "output/output-success.csv";
        String outputFailureFile = "output/output-failure.csv";

        flightFileRecordProcessor = new FlightFileRecordProcessor();

        flightFileRecordProcessor.processCsv(inputFile, outputValidFile, outputFailureFile);
    }

    @Test(expected = FlightBookingException.class)
    public void processCsv_EmptyFileTest () throws FlightBookingException {
        String inputFile = "src/test/resources/input/input-empty.csv";
        String outputValidFile = "output/output-success.csv";
        String outputFailureFile = "output/output-failure.csv";

        flightFileRecordProcessor = new FlightFileRecordProcessor();

        flightFileRecordProcessor.processCsv(inputFile, outputValidFile, outputFailureFile);
    }

}
