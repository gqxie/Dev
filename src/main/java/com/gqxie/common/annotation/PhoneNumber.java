package com.gqxie.common.annotation;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.util.StringUtils;
import sun.misc.Regexp;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Xie Guoqiang
 * @date 2017-12-02 15:29:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumber.Validator.class)
@SuppressWarnings("javadoc")
public @interface PhoneNumber
{
    public final static String PHONE = "^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,5-8])|(18[0-9]))\\d{8}$";

    String message() default "invalid phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<PhoneNumber, String>
    {

        @Override
        public void initialize(PhoneNumber arg0)
        {

        }

        @Override
        public boolean isValid(String arg0, ConstraintValidatorContext arg1)
        {
            return true;//StringUtil.isPhoneNumber(arg0);
        }
    }

}
