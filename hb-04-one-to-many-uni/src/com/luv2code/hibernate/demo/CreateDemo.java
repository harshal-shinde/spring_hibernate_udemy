package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {

		//create student object
		System.out.println("Creating new Instructor object..");
		Instructor instructor =  new Instructor("Harshal", "Shinde", "harshal.shinde@gmail.com");
		
		InstructorDetail instructorDetail = 
				new InstructorDetail("http://harshal.shinde", "Cricket");
		
		
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
		factory.close();
	}

	}

}
