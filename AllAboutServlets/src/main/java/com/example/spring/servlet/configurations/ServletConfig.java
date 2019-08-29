package com.example.spring.servlet.configurations;

import java.util.HashMap;
import java.util.Map;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServletRegistrationBean exampleServletBean() {
		ServletRegistrationBean reg = new ServletRegistrationBean(new Servlet1(), "/servlet1");

		Map<String, String> initParams = new HashMap<>();
		initParams.put("InitParam1", "initParam1");
		initParams.put("InitParam2", "initParam2");

		reg.setInitParameters(initParams); // not working?
		reg.setLoadOnStartup(1);
		return reg;
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

				servletContext.setInitParameter("initParam", "Injected init parameter");
				servletContext.setAttribute("contextParam", "Injected context parameter"); // global
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
		filter1.setOrder(1);
		return filter1;

	}

}
