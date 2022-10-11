package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class DemoApp {

	public static void main(String[] args) {
		// read configurations
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean from spring
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		// call the business method
		accountDAO.addAccount();
		// close context
		context.close();
	}

}
