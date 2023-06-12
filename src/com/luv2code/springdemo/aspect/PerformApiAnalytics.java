package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PerformApiAnalytics {


    @Before("com.luv2code.springdemo.aspect.LuvAopExpression.forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n ========>>> Perform api analytics");
    }
}
