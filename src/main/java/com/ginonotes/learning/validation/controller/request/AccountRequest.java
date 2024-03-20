package com.ginonotes.learning.validation.controller.request;

import com.ginonotes.learning.validation.controller.request.constraints.InEnum;
import com.ginonotes.learning.validation.controller.request.constraints.UniqueAccountNo;
import com.ginonotes.learning.validation.enums.AccountTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Account Request
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Data
public class AccountRequest implements Serializable {

    /**
     * Account id, required for update
     */
    @NotNull(message = "Account Id is required for update", groups = {Update.class})
    private String accountId;

    /**
     * Account number, should be unique, length should be less than 32
     */
    @NotNull(message = "Account No is required")
    @Length(max = 32, message = "Account No length should be less than 32")
    @UniqueAccountNo(groups = {Create.class})
    private String accountNo;

    /**
     * Account name, should not be empty, length should be less than 100
     */
    @NotNull
    @Length(max = 100, message = "Account Name length should be less than 100")
    private String accountName;

    /**
     * Account type, should be one of [SAVING, CURRENT, FIXED]
     */
    @NotNull
    @InEnum(value = AccountTypeEnum.class, message = "Account Type should be one of [SAVING, CURRENT, FIXED]")
    private String accountType;

    /**
     * Account balance, should not be null, should be greater than 0
     */
    @NotNull
    @Range(min = 0, message = "Account Balance should be greater than 0")
    private BigDecimal balance;

    /**
     * Account expiration date, should be in the future
     */
    @NotNull
    @Future(message = "Account Expiration Date should be in the future")
    private Date expireDate;

    /**
     * Address list, should not be empty
     */
    @Valid
    @NotNull
    @Length(min = 1, message = "Address List should not be empty")
    private List<@NotNull AddressInfo> addressList;
}
