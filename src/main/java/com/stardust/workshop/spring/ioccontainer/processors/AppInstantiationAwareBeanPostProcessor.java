package com.stardust.workshop.spring.ioccontainer.processors;


import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class AppInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String name) throws BeansException {
        System.out.println("************");
        System.out.println("Before instantiation: " + name);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String name) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object bean, String name) throws BeansException {
        System.out.println("************");
        System.out.println("post set properties " + name);
        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        System.out.println("************");
        System.out.println("before bean initialization " + name);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        System.out.println("************");
        System.out.println("after bean initialization " + name);
        return bean;
    }
}
