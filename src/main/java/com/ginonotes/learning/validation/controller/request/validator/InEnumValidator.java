package com.ginonotes.learning.validation.controller.request.validator;

import com.ginonotes.learning.validation.controller.request.constraints.InEnum;
import com.ginonotes.learning.validation.enums.BaseEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * In Enum Validator
 *
 * @author hongming
 * @since 2024/03/20
 */
public class InEnumValidator implements ConstraintValidator<InEnum, String> {

    private Class<? extends BaseEnum> enumClass;

    @Override
    public void initialize(InEnum constraintAnnotation) {
        enumClass = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (enumClass == null) {
            return false;
        }

        for (BaseEnum baseEnum : enumClass.getEnumConstants()) {
            if (baseEnum.getCode().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
