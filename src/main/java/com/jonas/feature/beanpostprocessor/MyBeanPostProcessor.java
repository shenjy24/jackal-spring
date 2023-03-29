package com.jonas.feature.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化前置
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("beanPostProcessorBean".equals(beanName)) {
            System.out.println("postProcessBeforeInstantiation:" + beanName);
        }
        // 默认返回null, 接下来调用doCreateBean方法实例化对象
        return null;
    }

    /**
     * 实例化后置
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("beanPostProcessorBean".equals(beanName)) {
            System.out.println("postProcessAfterInstantiation:" + beanName);
        }
        //返回false ：如果该方法返回false，并且不需要check，那么postProcessPropertyValues就会被忽略不执行；
        //返回true ： 如果返回true，postProcessPropertyValues就会被执行
        return true;
    }


    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("beanPostProcessorBean".equals(beanName)) {
            String message = String.format("postProcessProperties bean:%s, pvs:%s", bean, pvs);
            System.out.println(message);
        }
        // 此方法可对bean中的属性值进行、添加、修改、删除操作；
        // 对属性值进行修改，如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用
        return pvs;
    }

    /**
     * 初始化前置
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("beanPostProcessorBean".equals(beanName)) {
            System.out.println("postProcessBeforeInitialization:" + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化后置
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("beanPostProcessorBean".equals(beanName)) {
            System.out.println("postProcessAfterInitialization:" + beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
