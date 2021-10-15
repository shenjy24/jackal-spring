package com.jonas.feature.aop.jdkproxy;

/**
 * JDK 代理示例
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        //实例化目标对象
        JdkProxyService jdkProxyService = new JdkProxyServiceImpl();
        //实例化InvocationHandler
        JdkProxyInvocationHandler invocationHandler = new JdkProxyInvocationHandler(jdkProxyService);
        //根据目标对象生成代理对象
        JdkProxyService proxy = (JdkProxyService) invocationHandler.getProxy();
        //调用代理对象的方法
        proxy.print();
    }
}
