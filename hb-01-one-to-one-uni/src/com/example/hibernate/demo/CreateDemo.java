package com.example.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("henry","phillips","henry@example.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("henrychannel", "tennis");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
