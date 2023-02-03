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
import com.itstep.hibernatedemo.service.BookService;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/bookOperation")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public BookController() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// bookListing
		String target = request.getParameter("target");

		switch (target) {

		case "bookListing":
			List<Book> books = this.bookService.getBooks();
			request.setAttribute("books", books);
			request.getRequestDispatcher("bookLising.jsp").forward(request, response);
			break;
			
		case "editBook":
			int bookId = Integer.parseInt(request.getParameter("id"));
			Book book = this.bookService.getBook(bookId);
			request.setAttribute("book", book);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			break;
			
		case "deleteBook":
			bookId = Integer.parseInt(request.getParameter("id"));
			this.bookService.deleteBook(bookId);
			response.sendRedirect(request.getContextPath() + "/bookOperation?target=bookListing");
			break;
			
		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getParameter("target");

		switch (target) {
		case "saveBook":

			String author = request.getParameter("author");
			String title = request.getParameter("title");

			this.bookService.saveBook(author, title);

			request.setAttribute("MESSAGE", "Save successful!");
			request.getRequestDispatcher("home.jsp").forward(request, response);

			break;

		case "updateBook":

			author = request.getParameter("author");
			title = request.getParameter("title");
			int bookId = Integer.parseInt(request.getParameter("id"));

			Book book = new Book(author, title);
			book.setId(bookId);

			this.bookService.updateBook(book);

			response.sendRedirect(request.getContextPath() + "/bookOperation?target=bookListing");

			break;
		default:
			break;
		}
	}

}
