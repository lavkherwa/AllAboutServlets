package com.example.spring.servlet.ServletSample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Annotation based Servlet definition */
@WebServlet(name = "Servlet2", //
		description = "Servlet Using Annotations", //
		urlPatterns = { "/servlet2" })
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().println("Hello I am a servlet 2 \n" + //
				"Custom init param value is: " + request.getServletContext().getInitParameter("cutomParam") + "\n" + //
				"Value for response header correlation_id added in filter is: " + response.getHeader("correlation_id"));
	}
}
