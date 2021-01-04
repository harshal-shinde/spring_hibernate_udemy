package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {
		
		//Start transaction
		session.beginTransaction();
		
		//Get the instructor from database
		int instructorId = 1;
		Instructor instructor = session.get(Instructor.class,
				instructorId);
		
		//Create some courses
		Course physics = new Course("Higher Physics");
		Course chemistry = new Course("Bloody chemistry");
		
		//Add courses to instructor
		instructor.add(chemistry);
		instructor.add(physics);
		
		//Save the courses
		session.save(chemistry);
		session.save(physics);
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done..!!!");
		
	} catch(Exception ex) {
		ex.printStackTrace();
	} finally {
		factory.close();
	}

	}

}
