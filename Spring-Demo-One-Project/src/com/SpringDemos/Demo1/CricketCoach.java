package com.SpringDemos.Demo1;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    // Creating  Fields for email and team
    private String emailAddress;
    private String team;
    private String name;
    private String address;

    //setter methods for literal values
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress= emailAddress;
    }
    public void setTeam(String team)
    {
        this.team= team;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    //getter methods for literal values
    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return  address;
    }

    //our Setter method
    public void setFortuneService(FortuneService theFortuneService)
    {
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice bowling daily for 3 hours";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
