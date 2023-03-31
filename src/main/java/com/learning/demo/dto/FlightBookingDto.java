package com.learning.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * The type Flight booking dto.
 */
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class FlightBookingDto {
    @ToString.Include
    private String firstName;
    @ToString.Include
    private String lastName;
    private String pnr;
    private char fareClass;
    private LocalDate travelDate;
    private int pax;
    private LocalDate ticketingDate;
    private String email;
    private String mobilePhone;
    private String bookedCabin;

    /**
     * Sets flight booking details.
     *
     * @param fields the fields
     */
    public void setFlightBookingDetails(String[] fields) {
        this.setFirstName(fields[0].trim());
        this.setLastName(fields[1].trim());
        this.setPnr(fields[2].trim());
        this.setFareClass(fields[3].charAt(0));
        this.setTravelDate(LocalDate.parse(fields[4].trim()));
        this.setPax(Integer.parseInt(fields[5].trim()));
        this.setTicketingDate(LocalDate.parse(fields[6].trim()));
        this.setEmail(fields[7].trim());
        this.setMobilePhone(fields[8].trim());
        this.setBookedCabin(fields[9].trim());
    }
}
