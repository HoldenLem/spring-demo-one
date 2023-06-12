package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.springdemo.*.*(..))")
    public void forDaoPackage(){

    }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=========>>>> Executing @Before advice on addAccount");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n ========>>> Perform api analytics");
    }
}
