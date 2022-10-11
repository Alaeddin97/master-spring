package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class AddManyCoursesForAladdinDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create and save courses
			Course course1 = new Course("Topology Course");
			Course course2 = new Course("AWS Cloud Course");
			session.save(course1);
			session.save(course2);
			// get the student
			List<Student> aladdinStudent = session.createQuery("from Student s where s.firstName='Aladdin'").list();

			// assign courses to Aladdin then save them respectively
			for (Student student : aladdinStudent) {
				student.addCourse(course1);
				student.addCourse(course2);
				session.save(student);
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
			session.close();
		}
	}

}
