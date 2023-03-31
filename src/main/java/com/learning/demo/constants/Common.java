package com.learning.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Common.
 */
@Getter
@AllArgsConstructor
public enum Common {
    /**
     * Comma common.
     */
    COMMA(","),
    ;

    private String key;
}
