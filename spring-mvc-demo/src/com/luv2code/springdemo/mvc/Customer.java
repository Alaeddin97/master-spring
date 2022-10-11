package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
	private String firstName;
	@NotNull()
	@Size(min = 1, message = "is required")
	private String lastName;
	@NotNull(message = "is required")
	@Min(value = 0, message = "Must be equal or greater than zero")
	@Max(value = 10, message = "Must be equal or lower than 10")
	private Integer freePasse;
	@Pattern(regexp = "^[a-zA0-9]{5}",message = "Only 5 chars/digits")
	private String postalCode;
	@CourseCode
	private String  courseCode;

	public Customer() {

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

	public Integer getFreePasse() {
		return freePasse;
	}

	public void setFreePasse(Integer freePasse) {
		this.freePasse = freePasse;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
