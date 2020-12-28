package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	
	private String fileName ="/Users/admin/eclipse-workspace/spring-demo-annotations/src/com/luv2code/springdemo/fortune-data.txt";
	private List<String> theFortunes;
	
	private Random myRandom = new Random();
	
	public FileFortuneService() {
		System.out.println("FileFortuneService : inside default constructor");
		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		//Initialize array list 
		theFortunes = new ArrayList<String>();
		
		//Read fortunes from file
		try(BufferedReader br = new BufferedReader (
				new FileReader(theFile))) {
			String tempLine;
			
			while((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	@Override
	public String getDailyFortune() {
		int index = myRandom.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		return tempFortune;
	}

}
