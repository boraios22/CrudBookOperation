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
 * Servlet implementation class EditBookController
 */
@WebServlet("/editBook")
public class EditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		
		Book book = new BookDao().getBook(bookId);
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
