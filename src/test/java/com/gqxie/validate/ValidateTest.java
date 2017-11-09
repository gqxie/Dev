package com.gqxie.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.gqxie.entity.User;

public class ValidateTest
{

    /*@Test
    public void validateTest()
    {
        User user = new User();
        user.setAccount("account");
        user.setPwd("pwd");
        List<String> validateMsg = validate(user);
        validateMsg.forEach(row -> {
            System.out.println(row.toString());
        });
    }

    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public <T> List<String> validate(T t)
    {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations)
        {
            messageList.add(constraintViolation.getMessage());
        }
        return messageList;
    }*/
}
