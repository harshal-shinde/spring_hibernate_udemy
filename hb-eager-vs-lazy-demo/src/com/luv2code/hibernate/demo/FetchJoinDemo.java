package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
		
		Query<Instructor> query = session.createQuery("select i from Instructor  i "
				+ "JOIN FETCH i.courses "
				+ "where i.id =: theInstructorId",
				Instructor.class);
		
		query.setParameter("theInstructorId", instructorId);
		//Execute query and get instructor
		
		
		Instructor instructor = query.getSingleResult();
		
		System.out.println("luv2Code : Instructor: " + instructor);
		
		
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("luv2Code : Done..!!!");
		
	} catch(Exception ex) {
		ex.printStackTrace();
	} finally {
		factory.close();
	}

	}

}
