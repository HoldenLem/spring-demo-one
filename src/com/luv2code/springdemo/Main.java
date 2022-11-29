package com.luv2code.springdemo;

import com.luv2code.springdemo.BaseballCoach;
import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.TrackCoach;

public class Main {
    public static void main(String[] args) {
        //create object
        Coach coach = new TrackCoach();

        //use the object
        System.out.println(coach.getDailyWorkout());
    }
}