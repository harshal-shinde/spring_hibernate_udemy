package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	public String firstName;
	public String lastName;
	public String country;
	public String favoriteLanguage;
	public String[] operatingsystems;
	
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "Unites State of America");
	}

	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingsystems() {
		return operatingsystems;
	}

	public void setOperatingsystems(String[] operatingsystems) {
		this.operatingsystems = operatingsystems;
	}	

}
