package com.op_solutions.menu_service.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.op_solutions.menu_service.model.MenuItem;
import com.op_solutions.menu_service.repository.MenuRepo;

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
	
	public MenuItem addMenuItem(MenuItem menuItem)
	{
		if(restaurantService.fetchRestaurantById(menuItem.getRestaurant().getId()) == null)
			throw new RuntimeException("Restaurant not found");
		
		return repo.save(menuItem);
	}

	public void saveAll(List<MenuItem> items) {
		
		repo.saveAll(items);
		
	}

	public MenuItem getMenuItem(Long menuItemId) {
		
		return repo.findById(menuItemId).orElseThrow(() -> new RuntimeException("Menu item not found with id : " + menuItemId));
	}

	public Page<MenuItem> getMenuItemByName(String name, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size); // example: first page with 10 items
		
		 long start = System.currentTimeMillis();
		Page<MenuItem> menuItems =  repo.findItemsByName(name,pageable);
		
		 long end = System.currentTimeMillis();
		 long duration = end - start;
		 System.out.println("Time taken to fetch menu items by name: " + duration + " ms");
		
		return menuItems;
	}
	
}
