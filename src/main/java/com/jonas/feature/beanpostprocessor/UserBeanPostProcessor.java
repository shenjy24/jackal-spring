package com.jonas.feature.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserBeanPostProcessor implements BeanPostProcessor {

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
}
