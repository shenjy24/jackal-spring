package com.jonas.feature.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyInvocationHandler implements InvocationHandler {

    //目标对象，即需要被代理的对象
    private Object target;

    public JdkProxyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 此方法实现AOP增强的逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置处理
        System.out.println("---- before ----");
        //执行目标对象的方法
        Object result = method.invoke(target, args);
        //后置处理
        System.out.println("---- after ----");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     *
     * @return 代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
