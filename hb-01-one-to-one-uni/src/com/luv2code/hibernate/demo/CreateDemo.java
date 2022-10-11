package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;
public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Instructor.class)
						.buildSessionFactory();
		// create session
		Session session=factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new objects ...");
			InstructorDetail instructorDetail=new InstructorDetail("youtube.com","Guitar");;
			Instructor instructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
			instructor.setInstructorDetail(instructorDetail);
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the instructor ...");
			session.save(instructor);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			
		} 
	}

}
