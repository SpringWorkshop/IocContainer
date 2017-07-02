package com.stardust.workshop.spring.ioccontainer.processors;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AppBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        System.out.println("-------------");
        System.out.println("Before initialize bean:" + name);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        System.out.println("-------------");
        System.out.println("After initialize bean:" + name);
        return bean;
    }
}
