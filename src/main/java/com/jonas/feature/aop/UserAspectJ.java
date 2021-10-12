package com.jonas.feature.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class UserAspectJ {
    @Pointcut("execution(* *.init(..))")
    public void initAspect() {
    }

    @Before("initAspect()")
    public void beforeInitUser() {
        System.out.println("beforeInitUser");
    }

    @After("initAspect()")
    public void afterInitUser() {
        System.out.println("afterInitUser");
    }

    @Around("initAspect()")
    public void aroundInitUser(ProceedingJoinPoint joinPoint) {
        System.out.println("beforeAroundInitUser");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("afterAroundInitUser");
    }
}
