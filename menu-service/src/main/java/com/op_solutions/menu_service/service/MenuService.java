package com.op_solutions.menu_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op_solutions.menu_service.model.MenuItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepo repo;
	private final RestaurantService restaurantService;
	
	
	public List<MenuItem> getMenuList(Long restaurantId)
	{
		return repo.findByRestaurantId(restaurantId);
	}
	
	
}
