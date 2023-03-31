package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * The enum Discount offer.
 */
@Getter
@AllArgsConstructor
public enum DiscountOffer {

    /**
     * Fare class a discount offer.
     */
    FARE_CLASS_A('A', "OFFER_20"),
    /**
     * Fare class b discount offer.
     */
    FARE_CLASS_B('B', "OFFER_20"),
    /**
     * Fare class c discount offer.
     */
    FARE_CLASS_C('C', "OFFER_20"),
    /**
     * Fare class d discount offer.
     */
    FARE_CLASS_D('D', "OFFER_20"),
    /**
     * Fare class e discount offer.
     */
    FARE_CLASS_E('E', "OFFER_20"),
    /**
     * Fare class f discount offer.
     */
    FARE_CLASS_F('F', "OFFER_30"),
    /**
     * Fare class g discount offer.
     */
    FARE_CLASS_G('G', "OFFER_30"),
    /**
     * Fare class h discount offer.
     */
    FARE_CLASS_H('H', "OFFER_30"),
    /**
     * Fare class i discount offer.
     */
    FARE_CLASS_I('I', "OFFER_30"),
    /**
     * Fare class j discount offer.
     */
    FARE_CLASS_J('J', "OFFER_30"),
    /**
     * Fare class k discount offer.
     */
    FARE_CLASS_K('K', "OFFER_30"),
    /**
     * Fare class l discount offer.
     */
    FARE_CLASS_L('L', "OFFER_25"),
    /**
     * Fare class m discount offer.
     */
    FARE_CLASS_M('M', "OFFER_25"),
    /**
     * Fare class n discount offer.
     */
    FARE_CLASS_N('N', "OFFER_25"),
    /**
     * Fare class o discount offer.
     */
    FARE_CLASS_O('O', "OFFER_25"),
    /**
     * Fare class p discount offer.
     */
    FARE_CLASS_P('P', "OFFER_25"),
    /**
     * Fare class q discount offer.
     */
    FARE_CLASS_Q('Q', "OFFER_25"),
    /**
     * Fare class r discount offer.
     */
    FARE_CLASS_R('R', "OFFER_25"),
    ;

    private char fareClass;
    private String discountKey;

    /**
     * Discount offer based on fare class string.
     *
     * @param fareClass the fare class
     * @return the string
     */
    public static String discountOfferBasedOnFareClass(char fareClass) {
        Optional<DiscountOffer> discountOfferConstantOptional = Arrays.stream(DiscountOffer.values())
                .filter(discountOffer -> discountOffer.getFareClass() == fareClass)
                .findFirst();
        return discountOfferConstantOptional.map(DiscountOffer::getDiscountKey).orElse("NO OFFER CODE");
    }
}
