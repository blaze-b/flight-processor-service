package com.learning.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded=true)
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
}
