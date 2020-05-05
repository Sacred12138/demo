package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

@Configuration
@WebFilter(filterName = "webUrlFilter",urlPatterns = {"/**"})
public class WebUrlFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		System.out.println(servletRequest.getRequestURL().toString());
		chain.doFilter(request, response);
	}

}
