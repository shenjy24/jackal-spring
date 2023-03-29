package com.jonas.bean;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * 用于测试BeanPostProcessor
 */
@Data
public class BeanPostProcessorBean implements InitializingBean {
    private String value;

    // 一个 InitializingBean 执行一次
    // spring 初始化方法，作用是在BeanFactory完成属性设置之后,执行自定义的 初始化行为.
    // 执行顺序：在initMethod之前执行，在@PostConstruct之后执行
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
    }
}
