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

        MembershipDAO2 membershipDAO2 = context.getBean("membershipDAO2",MembershipDAO2.class);
        // call the business method
        Account account = new Account();
        accountDAO.addAccount(account);

        // lats call it again
        System.out.println("\n lets call it again \n");
        membershipDAO2.addAccount();

        // close the context
        context.close();
    }
}
