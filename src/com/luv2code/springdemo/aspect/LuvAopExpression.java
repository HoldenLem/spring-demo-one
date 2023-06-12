package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpression {
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
}
