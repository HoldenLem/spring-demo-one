package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO2 {

    public void addAccount() {
        System.out.println(MembershipDAO2.class + "DOING MY DB WORK: AGAIN  MEMBERSHIP ACCOUNT");
    }
}
