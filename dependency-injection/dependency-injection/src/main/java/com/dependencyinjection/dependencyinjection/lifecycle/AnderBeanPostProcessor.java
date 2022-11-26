package com.dependencyinjection.dependencyinjection.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(org.springframework.beans.factory.config.BeanPostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
