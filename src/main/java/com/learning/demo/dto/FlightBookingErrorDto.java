package com.learning.demo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.List;

/**
 * The type Flight booking error dto.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class FlightBookingErrorDto extends FlightBookingDto {

    @ToString.Include
    private String errorDetails;

    /**
     * Sets flight booking details.
     *
     * @param records      the records
     * @param errorDetails the error details
     */
    public void setFlightBookingDetails(String[] records, List<String> errorDetails) {
        super.setFlightBookingDetails(records);
        this.setErrorDetails(String.join("|", errorDetails));
    }

    /**
     * To csv string.
     *
     * @return the string
     */
    @SneakyThrows
    public String toCsv() {
        return (String.format("%s,%s,%s,%s,%s,%d,%s,%s,%s,%s,%s", super.getFirstName(), super.getLastName(),
                super.getPnr(), super.getFareClass(), super.getTravelDate(), super.getPax(),
                super.getTicketingDate(), super.getEmail(), super.getMobilePhone(), super.getBookedCabin(),
                this.getErrorDetails()));
    }
}
