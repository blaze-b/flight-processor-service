package com.learning.demo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class FlightBookingErrorDto extends FlightBookingDto {

    @ToString.Include
    private String errorDetails;

    public void setFlightBookingDetails(String[] records, List<String> errorDetails) {
        super.setFlightBookingDetails(records);
        this.setErrorDetails(String.join("|", errorDetails));
    }

    @SneakyThrows
    public String toCsv() {
        return (String.format("%s,%s,%s,%s,%s,%d,%s,%s,%s,%s,%s", super.getFirstName(), super.getLastName(),
                super.getPnr(), super.getFareClass(), super.getTravelDate(), super.getPax(),
                super.getTicketingDate(), super.getEmail(), super.getMobilePhone(), super.getBookedCabin(),
                this.getErrorDetails()));
    }
}
