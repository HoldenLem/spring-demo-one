package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LogToCloudAsync {


    @Before("com.luv2code.springdemo.aspect.LuvAopExpression.forDAOPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n ========>>> Logging to Cloud");
    }
}
