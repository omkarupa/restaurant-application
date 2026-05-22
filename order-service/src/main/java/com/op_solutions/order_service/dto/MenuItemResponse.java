package com.op_solutions.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemResponse {
	
	private Long id;
	private String name;
	private Double price;
	private boolean available;
	private Long restaurantId;
	
	public MenuItemResponse() {
		
	}

	public MenuItemResponse(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
