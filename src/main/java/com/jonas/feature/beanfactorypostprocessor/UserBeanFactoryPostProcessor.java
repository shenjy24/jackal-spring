package com.jonas.feature.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor是在spring容器加载了bean的定义文件之后，在bean实例化之前执行的。
 */
@Component
public class UserBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("userBean");
        MutablePropertyValues pv =  bd.getPropertyValues();
        if (pv.contains("userName")) {
            pv.addPropertyValue("userName", "Tom");
        }
        bd.setScope(BeanDefinition.SCOPE_SINGLETON);
    }

}
