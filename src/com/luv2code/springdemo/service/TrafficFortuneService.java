package com.luv2code.springdemo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneService {

    public String getFortune(){
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Exception heavy traffic this morning";
    }
}
