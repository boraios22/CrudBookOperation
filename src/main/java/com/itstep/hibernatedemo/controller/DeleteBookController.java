package com.itstep.hibernatedemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstep.hibernatedemo.dao.BookDao;

/**
 * Servlet implementation class DeleteBookController
 */
@WebServlet("/deleteBook")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		new BookDao().deleteBook(bookId);
		
		response.sendRedirect(request.getContextPath() + "/bookListing");
	}

}
