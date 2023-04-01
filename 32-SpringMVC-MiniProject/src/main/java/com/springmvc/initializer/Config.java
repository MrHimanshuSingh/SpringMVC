package com.springmvc.initializer;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.interceptor.MyInterceptor1;
import com.springmvc.interceptor.MyInterceptor2;
import com.springmvc.interceptor.MyInterceptor3;

@EnableWebMvc
@Configuration
@ComponentScan({"com.springmvc.controller","com.springmvc.service","com.springmvc.dao"})
public class Config implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/");
		registry.addInterceptor(new MyInterceptor2());
		registry.addInterceptor(new MyInterceptor3());
	}
	
	private DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bank");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}
	@Bean("template")
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public ViewResolver getResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/");
		view.setSuffix(".jsp");
		return view;
	}
}
