package com.hibernatedemo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {

            //create the objects
          Instructor tempInstructor  = new Instructor("Sharath","kumar","sharath@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com","Cricket");

             /* Instructor tempInstructor  = new Instructor("Bharath","kumar","temp@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("www.yotube.com/bharath","music");  */

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start the session
            session.beginTransaction();

            //save the instructor
            //Note:it will save InstructorDetails data as we are using cascade
            System.out.printf("saving instructor"+tempInstructor);
            session.save(tempInstructor);



            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
