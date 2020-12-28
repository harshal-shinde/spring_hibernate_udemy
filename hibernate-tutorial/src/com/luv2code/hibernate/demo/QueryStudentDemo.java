package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	//Create session
	Session session = factory.getCurrentSession();
	
	try {
		
		//Start transaction
		session.beginTransaction();
		
		//Query students
		List<Student> students = session.createQuery("from Student").getResultList();
		
		//Display the students
		displayStudents(students);
		
		//query student: lastName ='shinde'
		students = 
				session.createQuery("from Student s where s.lastName='shinde'").getResultList();
		
		System.out.println("\n\n Students last name is shinde");
		displayStudents(students);
		
		
		//Query students : lastName='shinde' or fisrtName ='duck' 
		students = 
				session.createQuery("from Student s where "
						+ "s.lastName='shinde' OR s.firstName='duck'").getResultList();
		
		System.out.println("\n\nStudents last name is shinde or fist name is duck");
		displayStudents(students);
		
		
		//Query Student : Like gmail.com
		students = 
				session.createQuery("from Student s where "
						+ "s.email like '%gmail.com'").getResultList();
		
		System.out.println("\n\nStudents email ends with @gmail.com");
		displayStudents(students);
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done..!!!");
		
	} catch(Exception ex) {
		ex.printStackTrace();
	} finally {
		factory.close();
	}

	}

	private static void displayStudents(List<Student> students) {
		for(Student tempStudent: students) {
			System.out.println(tempStudent);
		}
	}

}
