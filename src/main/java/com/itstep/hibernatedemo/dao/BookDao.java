package com.itstep.hibernatedemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.itstep.hibernatedemo.model.Book;

public class BookDao {
	
	private EntityManagerFactory factory;
	
	public BookDao() {
		factory = Persistence.createEntityManagerFactory("HibernateDemoPersistence");
	}
	
	public void saveBook(Book book) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(book);
		manager.getTransaction().commit();
	}
	
	public void updateBook(Book book) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(book);
		manager.getTransaction().commit();
	}
	
	public void deleteBook(int id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Book reference = manager.getReference(Book.class, id);
		manager.remove(reference);
		manager.getTransaction().commit();
	}
	
	public Book getBook(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Book.class, id);
	}
	
	public List<Book> listAll(){
		EntityManager manager = factory.createEntityManager();
		
		List<Book> books = manager.createQuery("from Book").getResultList();
		
		return books;
	}
	
}
