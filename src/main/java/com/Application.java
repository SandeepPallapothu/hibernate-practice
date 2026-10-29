package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import com.model.Students;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		select(sessionFactory);
		
		//selectByID(sessionFactory);
		
		//insert(sessionFactory);
		
		//update(sessionFactory);
		
		//delete(sessionFactory);
	}

	private static void delete(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("delete from student where id=?1");
		
		query.setParameter(1, 3);
		query.execute();
		
		session.getTransaction().commit();
	}

	private static void update(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("update student set name = ?1 where id = ?2");
		query.setParameter(1,"Loki");
		query.setParameter(2, 2);
		
		query.execute();
		session.getTransaction().commit();
	}

	private static void insert(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		MutationQuery query = session.createNativeMutationQuery("insert into student(name,marks) values(?1,?2)");
		
		query.setParameter(1, "chiru");
		query.setParameter(2, 88);
		
		query.execute();
		
		session.getTransaction().commit();
		
		System.out.println("row inserted");
	}

	private static void selectByID(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		NativeQuery<Students> query = session.createNativeQuery("Select * from student where id=5",Students.class);
		
		List<Students> list = query.list();
		
		System.out.println(list);
	}

	private static void select(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		NativeQuery<Students> query = session.createNativeQuery("Select * from student",Students.class);
		
		List<Students> list = query.list();
		
		System.out.println(list);
	}
	

}
