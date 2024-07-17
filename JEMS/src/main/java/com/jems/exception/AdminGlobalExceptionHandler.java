package com.jems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminGlobalExceptionHandler {

	@ExceptionHandler(InvalidEmailException.class)
	ResponseEntity invalidOtpException( ) {
		return new ResponseEntity("Invalid Email",HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidOtpException.class)
	ResponseEntity invalidEmailException( ) {
		return new ResponseEntity("Invalid Otp",HttpStatus.NOT_FOUND);
	}
}
