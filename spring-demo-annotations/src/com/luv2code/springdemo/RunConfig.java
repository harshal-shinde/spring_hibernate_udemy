package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("com.luv2code.springdemo")
public class RunConfig {
	
	@Bean
	public FortuneService coolFortuneService() {
		return new CoolFortuneService();
	}
	
	@Bean
	public Coach runCoach() {
		return new RunCoach(coolFortuneService());
	}

}
