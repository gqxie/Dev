package com.gqxie.common.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Xie Guoqiang
 * @date 2017-12-02 15:28:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Gender.Validator.class)
@SuppressWarnings("javadoc")
public @interface Gender
{

    String message() default "invalid gender";

    boolean allowBlank() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<Gender, String>
    {
        boolean allowBlank;

        @Override
        public void initialize(Gender gender)
        {
            allowBlank = gender.allowBlank();
        }

        @Override
        public boolean isValid(String arg0, ConstraintValidatorContext arg1)
        {
            if (arg0 == null)
            {
                return allowBlank;
            }
            return arg0.equalsIgnoreCase("M") || arg0.equalsIgnoreCase("F");
        }
    }
}