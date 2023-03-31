package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum DiscountOffer {

    FARE_CLASS_A('A', "OFFER_20"),
    FARE_CLASS_B('B', "OFFER_20"),
    FARE_CLASS_C('C', "OFFER_20"),
    FARE_CLASS_D('D', "OFFER_20"),
    FARE_CLASS_E('E', "OFFER_20"),
    FARE_CLASS_F('F', "OFFER_30"),
    FARE_CLASS_G('G', "OFFER_30"),
    FARE_CLASS_H('H', "OFFER_30"),
    FARE_CLASS_I('I', "OFFER_30"),
    FARE_CLASS_J('J', "OFFER_30"),
    FARE_CLASS_K('K', "OFFER_30"),
    FARE_CLASS_L('L', "OFFER_25"),
    FARE_CLASS_M('M', "OFFER_25"),
    FARE_CLASS_N('N', "OFFER_25"),
    FARE_CLASS_O('O', "OFFER_25"),
    FARE_CLASS_P('P', "OFFER_25"),
    FARE_CLASS_Q('Q', "OFFER_25"),
    FARE_CLASS_R('R', "OFFER_25"),
    ;

    private char fareClass;
    private String discountKey;

    public static String discountOfferBasedOnFareClass(char fareClass) {
        Optional<DiscountOffer> discountOfferConstantOptional = Arrays.stream(DiscountOffer.values())
                .filter(discountOffer -> discountOffer.getFareClass() == fareClass)
                .findFirst();
        return discountOfferConstantOptional.map(DiscountOffer::getDiscountKey).orElse("NO OFFER CODE");
    }
}
