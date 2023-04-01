package com.springmvc.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public void emptyResultDataAccessExceptionHandler() {

	}
}
