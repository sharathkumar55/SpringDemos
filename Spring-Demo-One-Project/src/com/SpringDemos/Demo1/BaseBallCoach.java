package com.SpringDemos.Demo1;

public class BaseBallCoach implements Coach{

    //define a private field for the dependency
    private FortuneService fortuneService;
    public BaseBallCoach(FortuneService theFortuneService)
    {

        fortuneService = theFortuneService;

    }
    @Override
    public String getDailyWorkout()
    {

        return "Practice Batting for 1 hour";
    }

    @Override
    public String getDailyFortune() {
        //use my fortuneService to get fortune();
        return fortuneService.getFortune();
    }
}
