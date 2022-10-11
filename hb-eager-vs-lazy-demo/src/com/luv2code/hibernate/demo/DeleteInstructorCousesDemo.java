package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;


import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
public class DeleteInstructorCousesDemo {

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
			// start a transaction
			session.beginTransaction();
			// get the course of id=id
			Course course=session.get(Course.class, 10);
			session.delete(course);
			// remove the link to the instructor
			course.setInstructor(null);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
			session.close();			
		} 
	}

}
