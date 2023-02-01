package com.itstep.hibernatedemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.hibernatedemo.dao.BookDao;
import com.itstep.hibernatedemo.model.Book;

/**
 * Servlet implementation class SaveEditBookController
 */
@WebServlet("/saveEditBook")
public class SaveEditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		int bookId = Integer.parseInt(request.getParameter("id"));
		
		Book book = new Book(author, title);
		book.setId(bookId);

		new BookDao().updateBook(book);
		
		response.sendRedirect(request.getContextPath() + "/bookListing");
	}

}
