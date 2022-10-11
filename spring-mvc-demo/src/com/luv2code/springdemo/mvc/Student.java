package com.luv2code.springdemo.mvc;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	public Student() {
//		 countryOptions=new LinkedHashMap<String,String>();
//		countryOptions.put("TK","Turkey");
//		countryOptions.put("US","United States of America");
//		countryOptions.put("TN","Tunisia");
//		countryOptions.put("BR","Brazil");
//		countryOptions.put("FR","France");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[]getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[]operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


}
