package com.hibernatedemo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

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
			
			
			// create a course
			//Course tempCourse = new Course("My Mission Book");
			//create more courses
			Course tempCourse1 = new Course("Course 3");
			Course tempCourse2 = new Course("Course 4");



			System.out.println("saving the course: "+tempCourse1);
			//save the transaction
			session.save(tempCourse1);
			session.save(tempCourse2);


			//create students
			Student tempStudent1 = new Student("Kar","Thik","new@gmail.com");
			Student tempStudent2 = new Student("ABX","kumar","abx@gmail.com");


			//add to students
			tempCourse1.addStudent(tempStudent1);
			tempCourse2.addStudent(tempStudent2);

			//saving the students
			session.save(tempStudent1);
			session.save(tempStudent2);

			System.out.println("saved students are"+tempCourse1.getStudents());
			System.out.println("saved students are"+tempCourse2.getStudents());

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





