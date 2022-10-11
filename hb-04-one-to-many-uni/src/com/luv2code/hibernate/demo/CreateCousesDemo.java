package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateCousesDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create instructor object
			System.out.println("Creating new objects ...");

			Course course1 = new Course("Geo");
			Course course2 = new Course("JAVA");

			// start a transaction

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 2);
			instructor.add(course1);
			instructor.add(course2);

			// save the instructor object
			session.save(course1);
			session.save(course2);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
			session.close();
		}
	}

}
