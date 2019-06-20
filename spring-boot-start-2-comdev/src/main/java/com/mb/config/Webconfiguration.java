package com.mb.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Webconfiguration {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	public FilterRegistrationBean<MyFilter> testFilterRegistrationBean() {
		
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<MyFilter>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.addInitParameter("paramName", "paramValue");
		registrationBean.setName("MyFilter");
		registrationBean.setOrder(1);
		return registrationBean;
	}
	
	
	public class MyFilter implements Filter{

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
				throws IOException, ServletException {

			HttpServletRequest request = (HttpServletRequest) srequest;
			System.out.println("this is MyFilter, url:" + request.getRequestURI());
			logger.info("this is MyFilter, url:" + request.getRequestURI());
			//放行
			chain.doFilter(srequest, sresponse);
		}
		
	}
}
