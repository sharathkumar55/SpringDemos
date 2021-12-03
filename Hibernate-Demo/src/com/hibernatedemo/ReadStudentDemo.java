package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {
            //create student object
            System.out.println("Creating new Student object ..");
            Student tempStudent = new Student("Raghu", "kumar", "Raghu@zemosolabs.com");

            //start the session
            session.beginTransaction();

            //save the student
            System.out.println("saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            //My new code for read the data from database
            //findout the student's id:primary key
            System.out.println("saved student Generated id"+tempStudent.getId());

            //now get a new session and start transcation
            session=factory.getCurrentSession();
            session.beginTransaction();


            //retrive student based on primary key
            System.out.println("getting student with id "+tempStudent.getId());

            Student myStudent = session.get(Student.class,tempStudent.getId());
           System.out.println(myStudent);
            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
