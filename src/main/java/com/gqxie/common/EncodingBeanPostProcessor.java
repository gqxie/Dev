package com.gqxie.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xie Guoqiang
 * @date 2017-11-23 16:56:25
 */
public class EncodingBeanPostProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException
    {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException
    {
        if (bean instanceof StringHttpMessageConverter)
        {
            MediaType mediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));
            List<MediaType> types = new ArrayList<>();
            types.add(mediaType);
            ((StringHttpMessageConverter) bean).setSupportedMediaTypes(types);
        }
        return bean;
    }
}
