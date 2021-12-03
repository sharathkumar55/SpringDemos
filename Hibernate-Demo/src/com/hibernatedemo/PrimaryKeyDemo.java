package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            System.out.println("Creating new  3 Student objects     ..");
            Student tempStudent1 = new Student("sharath", "kumar", "demo@zemosolabs.com");
            Student tempStudent2 = new Student("Bharath", "sai", "temp@zemosolabs.com");
            Student tempStudent3 = new Student("Swetha", "kumari", "kum@zemosolabs.com");

            //start the session
            session.beginTransaction();

            //save the students object
            System.out.println("saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
