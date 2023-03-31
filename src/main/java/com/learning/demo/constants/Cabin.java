package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Cabin {
    ECONOMY("Economy"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS("Business"),
    FIRST("First"),
    ;

    private String key;

    public static String getCabin(String key) {
        Optional<Cabin> cabinOptional = Arrays.stream(Cabin.values())
                .filter(cabin -> cabin.getKey().equalsIgnoreCase(key))
                .findFirst();
        return cabinOptional.map(Cabin::getKey).orElse("");
    }

    public static boolean containsCabin(String key) {
        return Arrays.stream(Cabin.values())
                .anyMatch(cabin -> cabin.getKey().equalsIgnoreCase(key));
    }


}
