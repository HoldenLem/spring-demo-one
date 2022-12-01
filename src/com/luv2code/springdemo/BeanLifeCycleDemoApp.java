package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCucle-applicationContext.xml");

        // retrieve bean from container
        Coach theCoach = context.getBean("myCoach", Coach.class);


        // print the result
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
