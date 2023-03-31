package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Common {
    COMMA(","),
    ;

    private String key;
}
