package com.learning.demo.dto;

import com.learning.demo.constants.DiscountOffer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class FlightBookingSuccessDto extends FlightBookingDto {

    @ToString.Include
    private String discountCode;

    @Override
    public void setFlightBookingDetails(String[] records) {
        super.setFlightBookingDetails(records);
        this.setDiscountCode(DiscountOffer.discountOfferBasedOnFareClass(super.getFareClass()));
    }

    public String toCsv() {
        return (String.format("%s,%s,%s,%s,%s,%d,%s,%s,%s,%s,%s", super.getFirstName(), super.getLastName(),
                super.getPnr(), super.getFareClass(), super.getTravelDate(), super.getPax(),
                super.getTicketingDate(), super.getEmail(), super.getMobilePhone(), super.getBookedCabin(),
                this.getDiscountCode()));
    }
}
