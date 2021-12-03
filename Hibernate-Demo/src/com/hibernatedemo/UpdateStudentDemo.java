package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {



            int studentId=1;

            //now get a new session and start transcation
            session=factory.getCurrentSession();
            session.beginTransaction();


            //retrive student based on primary key
            System.out.println("getting student with id "+studentId);

            Student myStudent = session.get(Student.class,studentId);

           System.out.println("Updating student with id=1");
           myStudent.setFirstName("saiRam");
            session.getTransaction().commit();

            //commit the transaction

            //update multiple data
            session= factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("update all emails");
            session.createQuery("UPDATE Student SET email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
