package com.jonas.feature.aop.cglibproxy;

/**
 * 目标对象，即被代理的类
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
public class CglibProxyService {
    public void invoke1() {
        System.out.println("CglibProxyService invoke1()");
    }

    public void invoke2() {
        System.out.println("CglibProxyService invoke2()");
    }
}

