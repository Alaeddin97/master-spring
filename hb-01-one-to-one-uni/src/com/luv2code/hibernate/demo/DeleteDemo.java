package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			int instructorId = 1;
			// start a transaction
			session.beginTransaction();
			// get the instructor by id
			Instructor instructor = session.get(Instructor.class, instructorId);
			System.out.println("Delete the instructor ...");
			if (instructor != null) {

				session.delete(instructor);
			}
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {

		}
	}

}
