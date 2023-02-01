package com.itstep.hibernatedemo.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itstep.hibernatedemo.model.Book;

public class App {

	public static void main(String[] args) {

		System.out.println("Hello world!");
		//EntityManager;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDemoPersistence");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Book book = new Book("Book5", "Someone3");
		manager.persist(book);
		
		manager.getTransaction().commit();
		
		

		/*SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
				
		session.beginTransaction();
		
		Book book = new Book("Book4", "Someone3");
		session.persist(book);
		
		Query query = session.createQuery("update Book set title='Book2' where id=1");
		query.executeUpdate();
		
		
		List<Book> books = session.createQuery("from Book", Book.class).getResultList();
		
		for(Book book1 : books) {
			System.out.println("title : " + book1);
		}
		
		
		Query query2 = session.createQuery("delete from Book where id=1");
		query2.executeUpdate();
		
		
		session.getTransaction().commit();*/

	}

}
