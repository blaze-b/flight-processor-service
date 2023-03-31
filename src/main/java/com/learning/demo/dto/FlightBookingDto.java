package com.learning.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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

    public void setFlightBookingDetails(String[] fields) {
        this.setFirstName(fields[0]);
        this.setLastName(fields[1]);
        this.setPnr(fields[2]);
        this.setFareClass(fields[3].charAt(0));
        this.setTravelDate(LocalDate.parse(fields[4]));
        this.setPax(Integer.parseInt(fields[5]));
        this.setTicketingDate(LocalDate.parse(fields[6]));
        this.setEmail(fields[7]);
        this.setMobilePhone(fields[8]);
        this.setBookedCabin(fields[9]);
    }
}
