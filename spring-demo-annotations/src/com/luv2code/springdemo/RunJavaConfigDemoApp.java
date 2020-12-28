package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunJavaConfigDemoApp {

	public static void main(String[] args) {
		//Read configuration file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RunConfig.class);
		//get the bean
		Coach theCoach = context.getBean("runCoach", Coach.class);
		
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
	
		
		//close the context
		context.close();

	}

}
