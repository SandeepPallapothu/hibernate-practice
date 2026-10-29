package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.model.Students;
import com.util.HibernateUtil;

public class HQL_Application {

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
		MutationQuery query = session.createMutationQuery("delete Students where id=?1");
		query.setParameter(1, 9);
		query.execute();
		
		session.getTransaction().commit();
	}

	private static void update(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MutationQuery query = session.createMutationQuery("update Students set names=?1 where id=?2 ");
		query.setParameter(1, "Thor");
		query.setParameter(2, 2);
		query.execute();
		
		session.getTransaction().commit();
	}

	private static void insert(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MutationQuery query = session.createMutationQuery("insert into Students(names,marks) values(?1,?2)");
		
		query.setParameter(1, "Steve");
		query.setParameter(2, 60);
		query.execute();
		
		session.getTransaction().commit();
	}

	private static void selectByID(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		SelectionQuery<Students> query = session.createSelectionQuery("From Students where id=?1",Students.class);
		query.setParameter(1, 6);
		query.list();
		List<Students> list = query.list();
		
		System.out.println(list);
	}

	private static void select(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		SelectionQuery<Students> query = session.createSelectionQuery("From Students",Students.class);
		
		List<Students> list = query.list();
		
		System.out.println(list);
	}

}
