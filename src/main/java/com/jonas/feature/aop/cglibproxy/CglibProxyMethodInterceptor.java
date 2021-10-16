package com.jonas.feature.aop.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxyMethodInterceptor
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
public class CglibProxyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke " + method);
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("After invoke " + method);
        return result;
    }
}
