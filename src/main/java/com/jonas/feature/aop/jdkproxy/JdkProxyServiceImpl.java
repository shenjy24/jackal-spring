package com.jonas.feature.aop.jdkproxy;

public class JdkProxyServiceImpl implements JdkProxyService {
    @Override
    public void invoke1() {
        System.out.println("---- invoke1 ----");
    }

    @Override
    public void invoke2() {
        System.out.println("---- invoke2 ----");
    }
}
