package com.luv2code.springdemo;

import com.luv2code.springdemo.AccountDAO;
import com.luv2code.springdemo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the been from config class
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        accountDAO.addAccount();

        // close the context
        context.close();
    }
}
