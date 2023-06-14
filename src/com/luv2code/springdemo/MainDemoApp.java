package com.luv2code.springdemo;

import com.luv2code.springdemo.AccountDAO;
import com.luv2code.springdemo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> account = null;

        try {
            // simulate exception
            boolean trip = true;
            account = theAccountDAO.findAccount(trip);
        } catch (Exception e) {
            System.out.println("\n\nMain program caught exception: " + e);
        }

        //display the accounts
        System.out.println("\n\nMain program");
        System.out.println(account);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
