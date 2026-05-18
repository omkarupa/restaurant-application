package com.op_solutions.menu_service.exception;

public class RestaurantNotFoundException extends RuntimeException {
	
	public RestaurantNotFoundException(String message)
	{
		super(message);
	}

}
