package com.op_solutions.menu_service.service;

import org.springframework.stereotype.Service;

import com.op_solutions.menu_service.exception.RestaurantNotFoundException;
import com.op_solutions.menu_service.model.Restaurant;
import com.op_solutions.menu_service.repository.RestaurantRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {
	
	private final RestaurantRepo repo;

	public  Restaurant fetchRestaurantById(Long restaurantId) {
		
		return repo.findById(restaurantId).orElseThrow(() -> new RestaurantNotFoundException("No restaurant found with Id : " + restaurantId));
		
		//new RestaurantNotFoundException("No restaurant found with Id : " + restaurantId)
	}

}
