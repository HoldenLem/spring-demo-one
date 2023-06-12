package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class BeforeAddAccountAdvice {

    @Before("com.luv2code.springdemo.aspect.LuvAopExpression.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=========>>>> Executing @Before advice on addAccount");
    }
}
