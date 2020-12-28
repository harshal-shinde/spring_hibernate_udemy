package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
		
		//Delete student
//		System.out.println("Deleting Student : "+ myStudent);
//		session.delete(myStudent);

		
		//Deleting student id = 2
		
		session.createQuery("delete from Student where id =2").executeUpdate();
		
		
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
