package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
		//Get session transaction
		Session session = factory.getCurrentSession();
		
		//Create employee object
		System.out.println("Creating employee Object");
		Employee employee = new Employee("Harshal", "Shinde", "Scientific Games");
		
		//start transaction
		session.beginTransaction();
		
		//Save Employee object
		System.out.println("Saving Employee");
		session.save(employee);
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done ...!!!");
		
		} finally {
			factory.close();
		}
	}

}
