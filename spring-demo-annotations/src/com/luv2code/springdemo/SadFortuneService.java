package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is sad day";
	}

}
