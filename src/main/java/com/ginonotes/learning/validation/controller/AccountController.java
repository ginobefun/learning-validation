package com.ginonotes.learning.validation.controller;

import com.ginonotes.learning.validation.controller.request.AccountRequest;
import com.ginonotes.learning.validation.controller.request.Create;
import com.ginonotes.learning.validation.controller.request.Update;
import com.ginonotes.learning.validation.controller.response.Response;
import jakarta.validation.groups.Default;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account Controller
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Slf4j
@RestController
public class AccountController {

    /**
     * Create account
     *
     * @param accountRequest account request
     * @return response with account id
     */
    @PostMapping("/api/createAccount")
    public Response<String> createAccount(@Validated(value = {Default.class, Create.class}) @RequestBody AccountRequest accountRequest) {
        log.info("Create account: {}", accountRequest);
        // TODO: Create account
        return Response.success("123456");
    }

    @PostMapping("/api/updateAccount")
    public Response<String> updateAccount(@Validated(value = {Default.class, Update.class}) @RequestBody AccountRequest accountRequest) {
        log.info("Update account: {}", accountRequest);
        // TODO: Update account
        return Response.success(accountRequest.getAccountId());
    }
}
