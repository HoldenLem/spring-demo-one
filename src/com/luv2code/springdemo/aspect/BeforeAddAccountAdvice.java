package com.luv2code.springdemo.aspect;

import com.luv2code.springdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Order(3)
public class BeforeAddAccountAdvice {


    // add a new advice for @AfterThrowing on findAccount

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.springdemo.AccountDAO.findAccount(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint joinPoint, Throwable theExc) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterThrowing on method " + method);

        // log the exception
        System.out.println("\n====> Exception is: " + theExc);


    }


    // add a new advice for @AfterReturning on findAccount
    @AfterReturning(
            pointcut = "execution(* com.luv2code.springdemo.AccountDAO.findAccount(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(
            JoinPoint joinPoint, List<Account> result) {

        // print the method
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method " + method);

        //printout the returning result
        System.out.println("\n====> result is " + result);

        // post-process the data

        // convert account name to Uppercase
        convertAccountNameToUpperCase(result);

        System.out.println("\n====> result is " + result);


    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        for (Account account : result) {
            String theUpperCase = account.getName().toUpperCase();

            account.setName(theUpperCase);
        }

    }


    @Before("com.luv2code.springdemo.aspect.LuvAopExpression.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        // display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n=========>>>> Method: " + methodSignature);

        //display methods args

        Object[] args = joinPoint.getArgs();

        for (Object tempArgs : args) {
            System.out.println(tempArgs);
        }
    }

}
