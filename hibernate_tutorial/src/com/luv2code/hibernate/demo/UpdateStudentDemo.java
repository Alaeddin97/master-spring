package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		// create session
		Session session=factory.getCurrentSession();
		
		try {
			//int studentId=1;
			session.beginTransaction();
			// retrieve student which id is 1
//			Student student=session.get(Student.class,studentId);
//			System.out.println("Getting student with id 1: \n"+student);
//			
//			System.out.println("Updating student ...");
//			student.setFirstName("Scooby");
//			session.save(student);
//			
//			System.out.println("Getting updated student");
//			Student updatedStudent=session.get(Student.class,studentId);
//			System.out.println(updatedStudent);
			session.createQuery("update Student s set email='scooby@gmail.com' where s.id=1 ").executeUpdate();
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			
		} 
	}

}
