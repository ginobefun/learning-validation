package com.ginonotes.learning.validation.controller.request.constraints;

import com.ginonotes.learning.validation.controller.request.validator.UniqueAccountNoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Unique AccountNo Constraint
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Target({FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UniqueAccountNoValidator.class)
public @interface UniqueAccountNo {

    String message() default "accountNo must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
