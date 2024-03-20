package com.ginonotes.learning.validation.controller.request.constraints;

import com.ginonotes.learning.validation.controller.request.validator.InEnumValidator;
import com.ginonotes.learning.validation.enums.BaseEnum;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Enum value Constraint
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Target({FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = InEnumValidator.class)
public @interface InEnum {

    /**
     * Enum class
     *
     * @return enum class
     */
    Class<? extends BaseEnum> value();

    String message() default "accountNo must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
