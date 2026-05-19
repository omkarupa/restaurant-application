package com.op_solutions.menu_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.op_solutions.menu_service.model.Restaurant;
import com.op_solutions.menu_service.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
	
	private final RestaurantService restaurantService;
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long restaurantId)
	{
		return  ResponseEntity.ok(restaurantService.fetchRestaurantById(restaurantId));
	}
	
	@GetMapping("")
	public ResponseEntity<List<Restaurant>> getAllRestaurants()
	{
		return ResponseEntity.ok(restaurantService.fetchAllRestaurants());
	}

}
