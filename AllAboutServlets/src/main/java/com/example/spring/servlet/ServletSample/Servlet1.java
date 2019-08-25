package com.example.spring.servlet.ServletSample;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		final HttpServletResponse response = (HttpServletResponse) res;
		res.getWriter().write("Hello I am a servlet 1 \n" + //
				"Custom init param (local) value is: " + req.getServletContext().getInitParameter("InitParam1") + "\n" + //
				"Custom init param value is: " + req.getServletContext().getInitParameter("initParam") + "\n" + //
				"Custom context param value is: " + req.getServletContext().getAttribute("contextParam") + "\n" + //
				"Value for response header correlation_id added in filter is: " + response.getHeader("correlation_id"));
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
