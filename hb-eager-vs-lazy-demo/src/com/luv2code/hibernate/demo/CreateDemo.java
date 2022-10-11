package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;


import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(Course.class)
						.buildSessionFactory();
		// create session
		Session session=factory.getCurrentSession();
		
		try {
			// create instructor object
			System.out.println("Creating new objects ...");
			Instructor instructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
			// start a transaction
			session.beginTransaction();
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, 1);
			instructor.setInstructorDetail(instructorDetail);
			// save the instructor object
			session.save(instructor);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			
		} 
	}

}
