package com.SpringDemos.Demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMethodsApp {
    public static void main(String[] args) {

        //Load the spring Configuration file i.e step 2 create a spring container
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrive the Bean from Spring Container
        CricketCoach theCricketCoach = context1.getBean("myCricketCoach",CricketCoach.class);

        //call methods on the bean
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());
        System.out.println(theCricketCoach.getName());
        System.out.println(theCricketCoach.getAddress());
        //close the context for better programming
        context1.close();


    }
}
