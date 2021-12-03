package com.hibernatedemo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {



            //start the session
            session.beginTransaction();

            //get the Instructor detail object
            int theId =3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);

            //print the instructor detail
            System.out.println("tempInstructor Detail"+tempInstructorDetail);

            //print asscoiated instructor
            System.out.println("Associated Instructor"+tempInstructorDetail.getInstructor());


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {

            //handle the leak issue by closing session
            session.close();
            factory.close();
        }
    }
}
