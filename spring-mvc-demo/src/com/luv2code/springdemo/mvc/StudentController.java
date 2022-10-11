package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String processForm(Model model) {
		// create a student object
		Student theStudent = new Student();
		// add student object to the model
		model.addAttribute("student", theStudent);
		// add the country options to the model
		model.addAttribute("theCountryOptions", countryOptions);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println(
				"theStudent: " + theStudent.getFirstName() + "  " + theStudent.getLastName() + ", and I'm from "
						+ theStudent.getCountry() + "\nMy favorite language is " + theStudent.getFavoriteLanguage()
						+"\nOperating system"+theStudent.getOperatingSystems());
		return "student-confirmation";
	}
}
