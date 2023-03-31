package com.learning.demo;

import com.learning.demo.exception.FlightBookingException;
import com.learning.demo.integration.FlightFileRecordProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlightProcessorApplication {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.info("flight-service-details-service-hello::entering......");
        FlightFileRecordProcessor flightFileRecordProcessor = new FlightFileRecordProcessor();
        String inputFile = "input/input.csv";
        String outputValidFile = "output/output-success.csv";
        String outputFailureFile = "output/output-failure.csv";
        //to process the input CSV file and generate the output files.
        try {
            flightFileRecordProcessor.processCsv(inputFile, outputValidFile, outputFailureFile);
        } catch (FlightBookingException e) {
            log.error("Processing Exception::error-detail::{}", e.getCause(), e.getCause());
        }
    }
}
