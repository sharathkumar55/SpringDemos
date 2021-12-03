package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {
            //create student object
            System.out.println("Creating new Student object ..");
            Student tempStudent = new Student("sharath", "kumar", "demo@zemosolabs.com");

            //start the session
            session.beginTransaction();

            //save the student
            System.out.println("saving the student");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
