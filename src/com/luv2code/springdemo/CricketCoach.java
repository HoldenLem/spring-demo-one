package com.luv2code.springdemo;

public class CricketCoach implements Coach{
    private String emailAddress;

    private String team;

    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-args constructor");
    }


    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method");
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Do great game";
    }

    @Override
    public String getDailyFortune() {
        return "Hey, " + fortuneService.getFortune();
    }
}
