package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO2 {

    public boolean addSillyMember() {

        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    public void goToSleep() {

        System.out.println(getClass() + ": I'm going to sleep now...");

    }
}
