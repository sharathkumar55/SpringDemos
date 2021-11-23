package com.SpringDemos.Demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {

        //Load the spring Configuration file i.e step 2 create a spring container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrive the Bean from Spring Container
        Coach theBaseBallCoach = context.getBean("myBaseBallCoach",Coach.class);
        Coach theTrackCoach = context.getBean("myTrackCoach",Coach.class);

        //call methods on the bean
       System.out.println(theBaseBallCoach.getDailyWorkout());
       System.out.println(theBaseBallCoach.getDailyFortune());
        System.out.println(theTrackCoach.getDailyWorkout());
       System.out.println(theTrackCoach.getDailyFortune());


        //close the context for better programming
         context.close();

    }
}
