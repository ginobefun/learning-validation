package com.ginonotes.learning.validation.controller.request;

import com.ginonotes.learning.validation.controller.request.constraints.InEnum;
import com.ginonotes.learning.validation.enums.AddressTypeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Address Info
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Data
public class AddressInfo implements Serializable {

    /**
     * Address Type, should be one of [HOME, OFFICE]
     */
    @NotNull
    @InEnum(value = AddressTypeEnum.class, message = "Address Type should be one of [HOME, OFFICE]")
    private String addressType;

    /**
     * Address, should not be empty, length should be less than 200
     */
    @NotNull
    @Length(max = 200, message = "Address length should be less than 200")
    private String address;

    /**
     * Zip code, should not be empty, length should be 6 digits
     */
    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "Zip Code should be 6 digits")
    private String zipCode;

    /**
     * Mobile phone number, should not be empty, length should be 11
     */
    @NotNull
    @Pattern(regexp = "^1[0-9]{10}$", message = "Mobile Phone No should be 11 digits")
    private String mobilePhoneNo;
}
