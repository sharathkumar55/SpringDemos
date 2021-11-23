package com.SpringDemos.Demo1;

public class TrackCoach implements Coach{
    private FortuneService fortuneService;

        public TrackCoach(FortuneService theFortuneService)
        {
            fortuneService = theFortuneService;

        }
    @Override
    public java.lang.String getDailyWorkout() {

            return "Run Hard for 5Km";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
