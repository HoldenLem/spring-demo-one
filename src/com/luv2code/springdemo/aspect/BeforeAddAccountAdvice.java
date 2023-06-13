package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(3)
public class BeforeAddAccountAdvice {

    @Before("com.luv2code.springdemo.aspect.LuvAopExpression.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        // display method signature
        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();
        System.out.println("\n=========>>>> Method: " + methodSignature);

        //display methods args

        Object[] args = joinPoint.getArgs();

        for(Object tempArgs: args){
            System.out.println(tempArgs);
        }
    }

}
