package com.itstep.hibernatedemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.hibernatedemo.dao.BookDao;
import com.itstep.hibernatedemo.model.Book;

@WebServlet("/saveBook")
public class SaveBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		
		Book book = new Book(author, title);
		
		new BookDao().saveBook(book);
		
		request.setAttribute("MESSAGE", "Save successful!");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
