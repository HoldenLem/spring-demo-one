package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.springdemo.*.*(..))")
    public void forDaoPackage() {

    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.springdemo.*.get*(..))")
    public void forDaoPackageGetter() {

    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.springdemo.*.set*(..))")
    public void forDaoPackageSetter() {

    }

    // create pointcut: include package...exclude getter/setter
    @Pointcut("forDaoPackage() && !(forDaoPackageGetter() || forDaoPackageSetter())")
    public void forDAOPackageNoGetterSetter() {

    }


    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=========>>>> Executing @Before advice on addAccount");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n ========>>> Perform api analytics");
    }
}
