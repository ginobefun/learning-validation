package com.ginonotes.learning.validation.controller.request.validator;

import com.ginonotes.learning.validation.controller.request.constraints.UniqueAccountNo;
import jakarta.validation.ConstraintValidator;

/**
 * @author ginozhang
 * @since 2024/03/20
 */
public class UniqueAccountNoValidator implements ConstraintValidator<UniqueAccountNo, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        // TODO
        return true;
    }
}
