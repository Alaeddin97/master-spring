package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext classPathXmlApplicationContext=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		CricketCoach theCoach=classPathXmlApplicationContext.getBean("myCricketCoach",CricketCoach.class);
		// call methods on the bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWordout());
		// call our new methods to get the literal values
		System.out.println(theCoach.getEmailAdress());
		System.out.println(theCoach.getTeam());
		// close the context
		classPathXmlApplicationContext.close();
	}

}
