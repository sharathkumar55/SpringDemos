package com.hibernatedemo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {


            //start the session
            session.beginTransaction();

           //get the instructor from db
            int theid=1;
             Instructor tempInstructor = session.get(Instructor.class,theid);


            System.out.println("Instructor is "+tempInstructor);

            //get the courses for the instructor
            System.out.println("Courses are "+tempInstructor.getCourses());


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
