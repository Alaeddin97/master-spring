package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			// query students
			System.out.println(session.createQuery("from Student").list());
			// query Students whose last name is Doe
			System.out.println(session.createQuery("from Student s where s.lastName='Doe'").list());

			// query Students whose last name is Doe or first name is Daffy
			System.out.println(
					session.createQuery("from Student s where " + "s.lastName='Doe' OR firstName='Daffy'").list());

			// query Students whose email like ...
			System.out.println(session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list());
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {

		}
	}

}
