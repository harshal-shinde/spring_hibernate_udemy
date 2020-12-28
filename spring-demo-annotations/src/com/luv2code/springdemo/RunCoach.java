package com.luv2code.springdemo;

public class RunCoach implements Coach {

	private FortuneService fortuneService;
	
	public RunCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	} 
	
	@Override
	public String getDailyWorkout() {
		return "Run atleast 10k/day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
