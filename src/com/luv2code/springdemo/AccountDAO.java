package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;

    private String level;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + ": in getLevel()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + ": in setLevel()");
        this.level = level;
    }
    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + " DOING MY DB WORK: ADD ACCOUNT" );
    }
}
