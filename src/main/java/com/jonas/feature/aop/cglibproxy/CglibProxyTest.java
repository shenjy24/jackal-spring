package com.jonas.feature.aop.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * CglibProxyTest
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibProxyService.class);
        enhancer.setCallback(new CglibProxyMethodInterceptor());

        CglibProxyService proxy = (CglibProxyService) enhancer.create();
        proxy.invoke1();
        proxy.invoke2();
    }
}
