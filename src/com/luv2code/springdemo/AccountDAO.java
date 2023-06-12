package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {

        System.out.println(getClass() + " DOING MY DB WORK: ADD ACCOUNT");
    }
}
