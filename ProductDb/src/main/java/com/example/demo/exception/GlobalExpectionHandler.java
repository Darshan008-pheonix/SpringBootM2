package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExpectionHandler {

	Logger logger=LoggerFactory.getLogger(GlobalExpectionHandler.class);
	@ExceptionHandler(ProductNotFoundException.class)
	ResponseEntity ProductIdHandler() {
		logger.error("ID Not Found");
		return new ResponseEntity("Id Not Found...!!",HttpStatus.NOT_FOUND);
	}
}



