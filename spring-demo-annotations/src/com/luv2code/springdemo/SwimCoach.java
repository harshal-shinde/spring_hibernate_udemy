package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	

	public SwimCoach(FortuneService theFortuneService) {
	
		fortuneService = theFortuneService;
	}
	

	public FortuneService getFortuneService() {
		return fortuneService;
	}


	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}


	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meteres as warmup";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
