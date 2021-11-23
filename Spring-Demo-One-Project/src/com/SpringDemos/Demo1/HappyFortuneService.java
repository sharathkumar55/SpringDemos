package com.SpringDemos.Demo1;

public class HappyFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is lucky day for you!!";
    }
}
