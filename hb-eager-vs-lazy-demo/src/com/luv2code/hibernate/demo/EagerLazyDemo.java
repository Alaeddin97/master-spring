package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;


import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
public class EagerLazyDemo {

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
			int id=2;
			// start a transaction
			session.beginTransaction();
			// get the instructor of id=id
			Instructor instructor= session.get(Instructor.class, id);
			// retrieve instructor data
			System.out.println("Instructor: "+instructor);			
			System.out.println("luv2code: courses:  "+instructor.getCourses());	
			// commit transaction
			session.getTransaction().commit();
			
			// since the data is lazy loaded this should fail because w'll go looking for them in database
			session.close();	
			System.out.println("The session is now closed....................");
			// to resolve the exception: option 1:(line 33)  we have to call getter as long as the session is open
			System.out.println("Done!");
		} finally {
			factory.close();	
		} 
	}

}
