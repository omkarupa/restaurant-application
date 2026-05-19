package com.op_solutions.menu_service.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
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
	
	public Restaurant addRestaurant(Restaurant restaurant)
	{
		return repo.save(restaurant);
	}

	public List<Restaurant> fetchAllRestaurants() {
		
		return repo.findAll();
	}

}
