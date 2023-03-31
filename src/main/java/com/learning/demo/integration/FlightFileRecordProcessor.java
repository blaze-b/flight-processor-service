package com.learning.demo.integration;

import com.learning.demo.dto.FlightBookingErrorDto;
import com.learning.demo.dto.FlightBookingSuccessDto;
import com.learning.demo.validator.FlightInputRecordValidator;
import com.learning.demo.validator.IFlightInputRecordValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static com.learning.demo.constants.Common.COMMA;

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
        log.info("process csv files::entering.......");
        try {
            List<String> inputRecords = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
            List<String> outputLines = new ArrayList<>();
            List<String> errorLines = new ArrayList<>();
            AtomicInteger index = new AtomicInteger();
            AtomicReference<String[]> headers = new AtomicReference<>();
            inputRecords.stream().map(records -> records.split(COMMA.getKey())).forEach(record -> {
                if (index.get() == 0) {
                    headers.set(Arrays.copyOf(record, record.length + 1));
                    headers.get()[headers.get().length - 1] = "Discount_code";
                    outputLines.add(String.join(COMMA.getKey(), headers.get()));
                    headers.get()[headers.get().length - 1] = "Error";
                    errorLines.add(String.join(COMMA.getKey(), headers.get()));
                } else {
                    FlightInputRecordValidator flightInputRecordValidator = (FlightInputRecordValidator)
                            this.flightInputRecordValidator;
                    boolean isValid = flightInputRecordValidator.validateCsvRecord(record);
                    if (isValid) {
                        FlightBookingSuccessDto flightBookingSuccessDto = new FlightBookingSuccessDto();
                        flightBookingSuccessDto.setFlightBookingDetails(record);
                        log.info("flight booking success details::{}", flightBookingSuccessDto);
                        outputLines.add(flightBookingSuccessDto.toCsv());

                    } else {
                        FlightBookingErrorDto flightBookingErrorDto = new FlightBookingErrorDto();
                        flightBookingErrorDto.setFlightBookingDetails(record, flightInputRecordValidator
                                .getErrorDetails());
                        log.info("flight booking error details::{}", flightBookingErrorDto);
                        errorLines.add(flightBookingErrorDto.toCsv());
                    }
                }
                index.incrementAndGet();
            });
            Files.write(Paths.get(successOutputFile), outputLines, StandardCharsets.UTF_8);
            Files.write(Paths.get(failureOutputFile), errorLines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
