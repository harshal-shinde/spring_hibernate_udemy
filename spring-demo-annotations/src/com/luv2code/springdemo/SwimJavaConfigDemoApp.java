package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//Read configuration file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
		//get the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		
		//close the context
		context.close();

	}

}
