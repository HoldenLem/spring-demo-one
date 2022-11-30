package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        //check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print the result
        System.out.println("\nPointing the same object " + result);

        System.out.println("\nMemory location for theCoach " + theCoach);

        System.out.println("\nMemory location for theCoach " + alphaCoach + "\n");

        //close the context
        context.close();
    }
}
