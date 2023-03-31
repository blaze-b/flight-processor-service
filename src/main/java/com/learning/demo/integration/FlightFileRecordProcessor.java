package com.learning.demo.integration;

import com.learning.demo.dto.FlightBookingDto;
import com.learning.demo.validator.FlightInputRecordValidator;
import com.learning.demo.validator.IFlightInputRecordValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlightFileRecordProcessor {

    private static final Logger log = LogManager.getLogger();

    private IFlightInputRecordValidator flightInputRecordValidator;

    public FlightFileRecordProcessor() {
        this.flightInputRecordValidator = new FlightInputRecordValidator();
    }

    public FlightFileRecordProcessor(IFlightInputRecordValidator iFlightInputRecordValidator) {
        this.flightInputRecordValidator = iFlightInputRecordValidator;
    }

    public void processCsv(String inputFile, String successOutputFile, String failureOutputFile) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter validOutputWriter = new BufferedWriter(new FileWriter(successOutputFile));
             BufferedWriter failureOutputWriter = new BufferedWriter(new FileWriter(failureOutputFile))) {
            String line = "";
            int index = 0;
            while ((line = inputReader.readLine()) != null) {
                String[] fields = line.split(",");
                if (index != 0) {
                    boolean isValid = ((FlightInputRecordValidator) flightInputRecordValidator).validateCsvRecord(fields);
                    if (isValid) {
                        FlightBookingDto flightBookingDto = new FlightBookingDto();
                        flightBookingDto.setFlightBookingDetails(fields);
                        log.info("Final dto={}", flightBookingDto);
                    } else {

                    }
                } else {
                    String[] headers = fields;
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            log.error("process::file-not-found-error-details::{}", e.getLocalizedMessage(), e.getCause());
        } catch (IOException e) {
            log.error("process::io-error-details::{}", e.getLocalizedMessage(), e.getCause());
        }
    }
}
