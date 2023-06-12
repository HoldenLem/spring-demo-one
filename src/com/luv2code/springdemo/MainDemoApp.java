package com.luv2code.springdemo;

import com.luv2code.springdemo.AccountDAO;
import com.luv2code.springdemo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO2 theMembershipDAO =
                context.getBean("membershipDAO2", MembershipDAO2.class);

        // call the business method
        Account myAccount = new Account();
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // call the accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setLevel("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getLevel();

        // call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
