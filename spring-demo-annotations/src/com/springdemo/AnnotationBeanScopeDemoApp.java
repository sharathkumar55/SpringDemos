package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrive  the bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        Coach theAlphaCoach = context.getBean("tennisCoach",Coach.class);

        //check if they are same
        boolean result= (theAlphaCoach == theCoach);
        System.out.println("Pointing to same location? "+result);
        System.out.println("memory location of theCoach "+theCoach);
        System.out.println("memory location of theAlphaCoach "+theAlphaCoach);

        //close the context
        context.close();

    }
}
