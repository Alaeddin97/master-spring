package com.luv2code.hibernate.demo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
//			session.createQuery("delete from Student s where s.id=2").executeUpdate();
			// Student myStudent=session.get(Student.class, 3);
			// session.delete(myStudent);
			// Student student=new
			// Student("Aladin","Garraoui","alaeddine.garraoui@gmail.com");
			Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", new Date(3));
			session.save(tempStudent);
			session.getTransaction().commit();

		} finally {
		}

	}
}
