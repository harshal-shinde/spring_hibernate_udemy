package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {
		//Use the session object to save java object
		
		//create student object
		System.out.println("Creating new student object..");
		Student tempStudent =  new Student("Harshal", "Shinde", "harshal.shinde@gmail.com");
		
		//Start transaction
		session.beginTransaction();
		
		//save the current object
		System.out.println("Saving student object");
		session.save(tempStudent);
		
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
