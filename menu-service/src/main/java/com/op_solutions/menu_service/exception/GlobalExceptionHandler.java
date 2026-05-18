package com.op_solutions.menu_service.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = RestaurantNotFoundException.class)
	public ResponseEntity<Error> handleRestaurantNotfoundException(RestaurantNotFoundException exception)
	{
		Error error = new Error(HttpStatusCode.valueOf(500), exception.getMessage());	
		return ResponseEntity.internalServerError().body(error);
		
	}

}
