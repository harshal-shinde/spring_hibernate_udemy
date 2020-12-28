package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
		Student tempStudent =  new Student("Duck", "Tales", "duck.tales@gmail.com");
		
		//Start transaction
		session.beginTransaction();
		
		//save the current object
		System.out.println("Saving student object");
		System.out.println(tempStudent);
		session.save(tempStudent);
		
		//Commit transaction
		session.getTransaction().commit();
		
		//MY NEW CODE
		
		
		//Find out the primary key
		System.out.println("Saved student. Generated id : " + tempStudent.getId());
		
		//Now get a new session and start transaction
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//Retrieve student based on id
		System.out.println("\n getting student id : " + tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
		
		System.out.println("Get complete : " + myStudent);
		
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
