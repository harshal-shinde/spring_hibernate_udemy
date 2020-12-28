package com.luv2code.springdemo;

public class CoolFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "I am cool fortune service";
	}

}
