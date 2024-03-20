package com.ginonotes.learning.validation.controller.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ginozhang
 * @since 2024/03/20
 */
@Data
public class Response<T> implements Serializable {

    /**
     * Response is success or not
     */
    @NotNull
    private Boolean success;

    /**
     * Response code
     */
    private String code;

    /**
     * Response message
     */
    private String message;

    /**
     * Response data
     */
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setSuccess(true);
        response.setCode("200");
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> fail(String code, String message) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
