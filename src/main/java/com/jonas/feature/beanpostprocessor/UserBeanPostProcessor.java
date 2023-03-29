package com.jonas.feature.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class UserBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 在bean初始化之前调用，例如 afterPropertiesSet 或 init-method
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName)) {
            System.out.println("postProcessBeforeInitialization:" + beanName);
        }
        return bean;
    }

    /**
     * 在bean初始化之后调用，例如 afterPropertiesSet 或 init-method
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName)) {
            System.out.println("postProcessAfterInitialization:" + beanName);
        }
        return bean;
    }


    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName)) {
            String message = String.format("postProcessProperties bean:%s, pvs:%s", bean, pvs);
            System.out.println(message);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
