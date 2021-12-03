package com.springdemo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService theFortuneService)
    {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim for 1 hour";
    }


    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }



}
