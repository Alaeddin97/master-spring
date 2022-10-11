package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;
public class GetInstructorDetailDemo {

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
			
			int instructorDetailId=6555;
			// start a transaction
			session.beginTransaction();
			
			// get instructor detail object
			InstructorDetail instructorDetail= session.get(InstructorDetail.class, instructorDetailId);
			System.out.println("Instructor detail of id 6: "+instructorDetail);
			// get the instructor associated to 
			Instructor instructor=instructorDetail.getInstructor();
			System.out.println("Instructor associated to instructorDetail of id 6: "+ instructor);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		} 
	}

}
