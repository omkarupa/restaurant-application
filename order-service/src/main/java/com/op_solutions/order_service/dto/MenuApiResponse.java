package com.op_solutions.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuApiResponse {

	private Long id;
	private String name;
	private Double price;
	private boolean available;
	private String description;
	private RestaurantInfo restaurant;
	
}
