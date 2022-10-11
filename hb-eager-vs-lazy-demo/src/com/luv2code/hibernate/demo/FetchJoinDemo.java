package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class FetchJoinDemo {

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
			// retrieve instructor data with courses that are lazy loaded: Option 2: Query the data directly from the database when the session is open		
			Query<Instructor> query=session.createQuery("SELECT i FROM Instructor i "
					+ "JOIN FETCH i.courses  "
					+ "where i.id=:idInstructor",Instructor.class);
			query.setParameter("idInstructor", id);
			Instructor instructor= query.getSingleResult();
			// commit transaction
			session.getTransaction().commit();
			// since the data is lazy loaded this should fail because w'll go looking for them in database
			session.close();	
			System.out.println("The session is now closed....................");
			System.out.println("The courses of this instructor: "+instructor.getFirstName()+" : "+instructor.getCourses());
			System.out.println("Done!");
		} finally {
			factory.close();	
		} 
	}

}
