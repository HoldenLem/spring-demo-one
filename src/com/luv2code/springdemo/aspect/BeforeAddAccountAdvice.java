package com.luv2code.springdemo.aspect;

import com.luv2code.springdemo.Account;
import com.luv2code.springdemo.MainDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class BeforeAddAccountAdvice {

    private Logger logger = Logger.getLogger(getClass().getName());
    @Around("execution(* com.luv2code.springdemo.service.TrafficFortuneService.getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====> Executing @Around on method " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = joinPoint.proceed();

        // get begin timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it

        long duration = end - begin;

        logger.info("\n ====>> Duration: " + duration / 1000.0 + "seconds");

        return result;
    }


    @After("execution(* com.luv2code.springdemo.AccountDAO.findAccount(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====> Executing @After (finally) on method " + method);


    }


    // add a new advice for @AfterThrowing on findAccount
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.springdemo.AccountDAO.findAccount(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint joinPoint, Throwable theExc) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====> Executing @AfterThrowing on method " + method);

        // log the exception
        logger.info("\n====> Exception is: " + theExc);


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
        logger.info("\n====> Executing @AfterReturning on method " + method);

        //printout the returning result
        logger.info("\n====> result is " + result);

        // post-process the data

        // convert account name to Uppercase
        convertAccountNameToUpperCase(result);

        logger.info("\n====> result is " + result);


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
        logger.info("\n=========>>>> Method: " + methodSignature);

        //display methods args

        Object[] args = joinPoint.getArgs();

        for (Object tempArgs : args) {
            logger.info((String) tempArgs);
        }
    }

}
