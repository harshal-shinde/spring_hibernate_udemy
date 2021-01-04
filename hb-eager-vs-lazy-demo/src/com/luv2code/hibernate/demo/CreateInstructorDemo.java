package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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

		Instructor instructor =  new Instructor("Sunil", "Shetty", "Sunil.Shetty@gmail.com");
		
		InstructorDetail instructorDetail = 
				new InstructorDetail("http://anna.com", "Acto");
		
		
		instructor.setInstructorDetail(instructorDetail);
		
		//Start transaction
		session.beginTransaction();
		
		//save the current object as well as 
		//associated details object
		//Because of CascadeType.ALL
		
		System.out.println("Saving Instructor object");
		session.save(instructor);
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done..!!!");
		
	} catch(Exception ex) {
		ex.printStackTrace();
	} finally {
		session.close();
		factory.close();
	}

	}

}
