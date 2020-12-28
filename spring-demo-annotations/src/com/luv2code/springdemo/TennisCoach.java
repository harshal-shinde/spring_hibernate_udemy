package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("TennisCoach : inside setFortuneService() method");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "TennisCoach : getDailyWorkout() - Complete daily 5 km run ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
