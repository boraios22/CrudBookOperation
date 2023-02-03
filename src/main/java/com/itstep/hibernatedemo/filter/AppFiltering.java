package com.itstep.hibernatedemo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppFiltering implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.print("Start filtering");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println("Start filtering");
		System.out.println(req.getRequestURI());

		if (req.getRequestURI().endsWith(".jsp")) {
			
			res.sendRedirect("error.html");
			
		} else {
			
			chain.doFilter(request, response);
			
		}
	}

}
