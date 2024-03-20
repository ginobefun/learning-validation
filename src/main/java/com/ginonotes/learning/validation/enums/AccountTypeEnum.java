package com.ginonotes.learning.validation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Account Type Enum
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Getter
@AllArgsConstructor
public enum AccountTypeEnum implements BaseEnum {

    /**
     * Savings Account
     */
    SAVING("SAVING", "Savings Account"),

    /**
     * Current Account
     */
    CURRENT("CURRENT", "Current Account"),

    /**
     * Fixed Account
     */
    FIXED("FIXED", "Fixed Account");

    private final String code;

    private final String desc;
}
