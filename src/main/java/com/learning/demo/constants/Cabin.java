package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cabin {
     ECONOMY("Economy"),
     PREMIUM_ECONOMY("Premium Economy"),

    ;

    private String key;

}
