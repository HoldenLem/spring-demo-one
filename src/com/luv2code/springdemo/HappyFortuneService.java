package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService{

    // create an array of strings
    private final String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private final Random myRandom = new Random();

    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(data.length);

        return data[index];
    }

}
