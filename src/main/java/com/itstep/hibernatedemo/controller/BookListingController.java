package com.itstep.hibernatedemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.hibernatedemo.dao.BookDao;
import com.itstep.hibernatedemo.model.Book;

@WebServlet("/bookListing")
public class BookListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	
	public BookListingController() {
		bookDao = new BookDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> books = bookDao.listAll();
		
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("bookLising.jsp").forward(request, response);
		
	}

}
