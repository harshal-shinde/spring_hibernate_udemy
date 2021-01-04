package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {
		//Start transaction
		session.beginTransaction();
		
		//Get the instruction details object
		int instructorDetailId = 6;
		
		InstructorDetail  instructorDetail = 
				session.get(InstructorDetail.class, instructorDetailId);
		
		
		
		//Print the instructor details object
		System.out.println("Instructor details" + instructorDetail);
		
		//Print the associated Instructor
		System.out.println("The associated instructor" +
				instructorDetail.getInstructor());
		
		//Delete instructor detail delete
		System.out.println("Deleting instructor detail" +
				instructorDetail);
		
		//Remove the associated references
		instructorDetail.getInstructor().setInstructorDetail(null);
		
		session.delete(instructorDetail);
		
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
