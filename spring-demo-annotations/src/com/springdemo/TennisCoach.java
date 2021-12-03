package com.springdemo;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component

public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

   /* @Autowired
    public TennisCoach(FortuneService theFortuneService)
    {
       // System.out.println("$$$$$"+theFortuneService+"$$$$");
        fortuneService = theFortuneService;
    }*/
 /* @Autowired
  public void setFortuneService(FortuneService theFortuneService) {
        System.out.println("$$$ Inside Setter method $$$");
       System.out.println("$$$$$"+theFortuneService+"$$$$");

      this.fortuneService = theFortuneService;
    } */
   /*  @Autowired
    public void setToAnyMethod(FortuneService theFortuneService)
    {
        System.out.println("$$$ Inside Any method $$$");
        this.fortuneService = theFortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice daily volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //add init method
    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("inside init method");
    }

    //add destroy method
    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("inside destroy method ");
    }

}
