package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource("classpath:sports.properties")
public class SportConfig {

    //define bean for our sad fortune service
        @Bean
        public FortuneService sadFortuneService()
        {
            return new SadFortuneService();
        }


    //define bean for swim coach and inject dependency
    @Bean
    public Coach swimCoach()
    {
        //System.out.println("$$$"+sadFortuneService()+"$$$");
        return new SwimCoach(sadFortuneService());
    }
}
