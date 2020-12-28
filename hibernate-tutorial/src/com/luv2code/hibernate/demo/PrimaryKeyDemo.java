package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Use the session object to save java object
			
			//create 3 students object
			System.out.println("Creating 3 student objects..");
			Student tempStudent1 =  new Student("Raju", "Furde", "Raju.furde@gmail.com");
			Student tempStudent2 =  new Student("Priyanka", "Mohite", "pm@gmail.com");
			Student tempStudent3 =  new Student("Vilas", "Kumkar", "vilas.kumkar@gmail.com");
			//Start transaction
			session.beginTransaction();
			
			//save the current object
			System.out.println("Saving student object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
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
