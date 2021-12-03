package com.hibernatedemo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {

            //start the session
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display students
            for(Student temStudent : theStudents)
            {
                System.out.println(temStudent);
            }
            //query students :lastname ='kumar'
            theStudents = session.createQuery("from Student s WHERE s.lastName='kumar'").list();


            //display the students
            System.out.println("$$$ last name starts with kumar");
            for(Student temStudent : theStudents)
            {
                System.out.println(temStudent);
            }
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
