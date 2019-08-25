package com.example.spring.servlet.configurations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring.servlet.Filters.Filter1;
import com.example.spring.servlet.ServletSample.Servlet1;

@Configuration
public class ServletConfig {

	/* Programmatically configuring Servlet is as below */
	@Bean
	public ServletRegistrationBean<Servlet1> exampleServletBean() {
		ServletRegistrationBean<Servlet1> servlet1 = new ServletRegistrationBean<Servlet1>(new Servlet1(), "/servlet1");
		servlet1.setLoadOnStartup(1);
		return servlet1;
	}

	/*
	 * You can get hold of Servlet context on startup and add parameters to it
	 * 
	 * Also this is an opportunity if you want to do any one time activity on
	 * Servlet startup
	 * 
	 */
	@Bean
	public ServletContextInitializer servletContextInitializer() {

		return new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter("cutomParam", "Injected custom param");

				/* Do something like register jobs etc.. */
				doSomething();

			}
		};
	}

	public void doSomething() {
		System.out.println("I am doing something on servlet startup ;)");
	}

	/* Programmatically injecting filters for Servlet endpoints */
	@Bean
	public FilterRegistrationBean<Filter1> servletFilter1() {

		final FilterRegistrationBean<Filter1> filter1 = new FilterRegistrationBean<Filter1>(new Filter1());
		filter1.addUrlPatterns("/*");
		return filter1;

	}

}