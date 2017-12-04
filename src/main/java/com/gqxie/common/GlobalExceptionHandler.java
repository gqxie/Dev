package com.gqxie.common;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * @author Xie Guoqiang
 * @date 2017-12-02 15:40:41
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler
{
    private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        return new MethodValidationPostProcessor();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ValidationException exception)
    {
        logger.error("bad request, " + exception.getMessage());
        return "bad request, " + exception.getMessage();
    }
}

