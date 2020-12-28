package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {
		int studentId = 1;
		
		//Now get a new session and start transaction
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//Retrieve student based on id
		System.out.println("\nGetting student id : " + studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		System.out.println("Updating student");
		myStudent.setFirstName("Priyanka");
		
		//Commit transaction
		session.getTransaction().commit();
		
		
		
		//Update bulk
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//update email for all  students
		System.out.println("Updating email for all students");
		session.createQuery("update Student set email='samurai@gmail.com'")
		.executeUpdate();
		
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
