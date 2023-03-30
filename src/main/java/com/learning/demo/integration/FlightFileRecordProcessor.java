package com.learning.demo.integration;

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

    public void process(String inputFile, String successOutputFile, String failureOutputFile) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter validOutputWriter = new BufferedWriter(new FileWriter(successOutputFile));
             BufferedWriter failureOutputWriter = new BufferedWriter(new FileWriter(failureOutputFile))) {

        } catch (FileNotFoundException e) {
            log.error("process::error-details::{}", e.getLocalizedMessage(), e.getCause());
        } catch (IOException e) {
            log.error("process::error-details::{}", e.getLocalizedMessage(), e.getCause());
        }
    }
}
