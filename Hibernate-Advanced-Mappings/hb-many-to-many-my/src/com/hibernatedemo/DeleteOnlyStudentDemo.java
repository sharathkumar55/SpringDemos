package com.hibernatedemo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOnlyStudentDemo {

    public static void main(String[] args) {


    // create session factory
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    // create session
    Session session = factory.getCurrentSession();

		try {

        // start a transaction
        session.beginTransaction();

        int theStudentId =1;

        Student tempStudent = session.get(Student.class,theStudentId);
            tempStudent.setCourses(null);
            System.out.println("deleting student:"+tempStudent);
        session.delete(tempStudent);
        // commit transaction
        session.getTransaction().commit();

        System.out.println("Done!");
    }
		finally {

        // add clean up code
        session.close();

        factory.close();
    }
    }
}
