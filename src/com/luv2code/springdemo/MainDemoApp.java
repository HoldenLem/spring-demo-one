package com.luv2code.springdemo;

import com.luv2code.springdemo.AccountDAO;
import com.luv2code.springdemo.DemoConfig;
import com.luv2code.springdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp {


    private static Logger logger = Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        // call the service
        logger.info("\n Main program");
        logger.info("Calling the service");

        String data = trafficFortuneService.getFortune();

        logger.info("\n My fortune is: " + data);

        // close the context
        context.close();
    }
}
