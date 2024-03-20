package com.ginonotes.learning.validation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ginozhang
 * @since 2024/03/20
 */
@Getter
@AllArgsConstructor
public enum AddressTypeEnum implements BaseEnum {

    /**
     * Home Address
     */
    HOME("HOME", "Home Address"),

    /**
     * Office Address
     */
    OFFICE("OFFICE", "Office Address");

    private final String code;

    private final String desc;
}
