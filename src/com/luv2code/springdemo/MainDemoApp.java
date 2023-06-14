package com.luv2code.springdemo;

import com.luv2code.springdemo.AccountDAO;
import com.luv2code.springdemo.DemoConfig;
import com.luv2code.springdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        // call the service
        System.out.println("\n Main program");
        System.out.println("Calling the service");

        String data = trafficFortuneService.getFortune();

        System.out.println("\n My fortune is: " + data);

        // close the context
        context.close();
    }
}
