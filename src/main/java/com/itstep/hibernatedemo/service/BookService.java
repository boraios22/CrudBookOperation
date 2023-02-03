package com.itstep.hibernatedemo.service;

import java.util.List;

import com.itstep.hibernatedemo.dao.BookDao;
import com.itstep.hibernatedemo.model.Book;

public class BookService {
	private BookDao bookDao;
	
	public BookService() {
		bookDao = new BookDao();
	}

	public void saveBook(String author, String title) {
		
		Book book = new Book(author, title);
		
		this.bookDao.saveBook(book);
	}
	
	public void deleteBook(int bookId) {
		this.bookDao.deleteBook(bookId);
	}
	public Book getBook(int bookId) {
		Book book = bookDao.getBook(bookId);
		
		return book;
	}
	
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	

	public List<Book> getBooks(){
		List<Book> books = bookDao.listAll();
		return books;
	}
}
