package com.luv2code.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    public TrackCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Run a hurd 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it "+ fortuneService.getFortune();
    }
}
