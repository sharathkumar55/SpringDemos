package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Delete;

public class DeleteStudentDemo {
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

           System.out.println("delete student with id=1");
           session.delete(myStudent);

           //commit the transaction

            //delete multiple data

            System.out.println("delete  last name= kumar");
            session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();
                    session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
