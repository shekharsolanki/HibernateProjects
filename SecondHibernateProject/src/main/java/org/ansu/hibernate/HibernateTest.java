package org.ansu.hibernate;

import java.util.List;

import org.ansu.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<UserDetails> query = session.createQuery("from UserDetails where userId > 5");
		List<UserDetails> userDetails = query.list();

		session.getTransaction().commit();
		session.close();

//		System.out.println("Size of list result = " + userDetails.size());
		System.out.println(userDetails.get(1).getUserName());
	}
}