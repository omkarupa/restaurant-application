package com.op_solutions.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantInfo {
	
	private Long id;
	private String name;
	private boolean isPureVeg;
	private boolean isActive;

}
