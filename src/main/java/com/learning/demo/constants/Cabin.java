package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * The enum Cabin.
 */
@Getter
@AllArgsConstructor
public enum Cabin {
    /**
     * Economy cabin.
     */
    ECONOMY("Economy"),
    /**
     * The Premium economy.
     */
    PREMIUM_ECONOMY("Premium Economy"),
    /**
     * Business cabin.
     */
    BUSINESS("Business"),
    /**
     * First cabin.
     */
    FIRST("First"),
    ;

    private String key;

    /**
     * Gets cabin.
     *
     * @param key the key
     * @return the cabin
     */
    public static String getCabin(String key) {
        Optional<Cabin> cabinOptional = Arrays.stream(Cabin.values())
                .filter(cabin -> cabin.getKey().equalsIgnoreCase(key))
                .findFirst();
        return cabinOptional.map(Cabin::getKey).orElse("");
    }

    /**
     * Contains cabin boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public static boolean containsCabin(String key) {
        return Arrays.stream(Cabin.values())
                .anyMatch(cabin -> cabin.getKey().equalsIgnoreCase(key));
    }


}
