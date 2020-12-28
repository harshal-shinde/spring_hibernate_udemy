package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String []data = {
			"You are stars are amazing",
			"You will win 3 consecutive matches",
			"Keep calm and work hard"
	};
	
	private Random myRandom= new Random();
	@Override
	public String getDailyFortune() {
		int index = myRandom.nextInt(data.length);
		String myFortune = data[index];
		return myFortune;
	}

}
