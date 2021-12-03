package com.hibernatedemo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();




        //create session
        Session session = factory.getCurrentSession();

        try {

            //create the objects
            Instructor tempInstructor  = new Instructor("sai","ram","temp2333@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("www.yotube.com/sai","music");

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
            factory.close();
        }
    }
}
