package com.hibernatedemo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Option2HQLDemo {
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
            //option2 :hybernate query with HQl

           //get the instructor from db
            int theid=1;


            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                    +"JOIN FETCH i.courses "
                                        +"where i.id=:theInstructorId ",Instructor.class);

                    //set parameter on query
            query.setParameter("theInstructorId",theid);

            //execute the query
            Instructor tempInstructor = query.getSingleResult();
            System.out.println("$$$$$ :Instructor is "+tempInstructor);


            //commit transaction
            session.getTransaction().commit();
            session.close();

            //it will work because we used HQL which is option2
            System.out.println("$$$$$ :Courses are "+tempInstructor.getCourses());

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
