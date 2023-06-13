package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccount() {

        List<Account> accounts = new ArrayList<>();

        // create accounts
        Account one = new Account("John","Silver");
        Account two = new Account("Madhu","Platinum");
        Account three = new Account("Luca","Gold");

        // add accounts to rhe list
        accounts.add(one);
        accounts.add(two);
        accounts.add(three);

        return accounts;
    }

    @Override
    public String toString() {
        return "AccountDAO{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
