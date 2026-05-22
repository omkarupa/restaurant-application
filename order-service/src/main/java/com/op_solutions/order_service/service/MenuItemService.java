package com.op_solutions.order_service.service;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.op_solutions.order_service.dto.MenuApiResponse;
import com.op_solutions.order_service.dto.MenuItemResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuItemService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name = "menuService", fallbackMethod = "getMenuItemFallback")
	public MenuItemResponse getMenuItemById(Long id) 
	{
		
			
			String url = "http://localhost:8091/api/menuItems/" + id;
			
			MenuApiResponse apiResponse = restTemplate.getForObject(url, MenuApiResponse.class);
			
			MenuItemResponse menuItem = new MenuItemResponse();
			menuItem.setId(apiResponse.getId());
			menuItem.setName(apiResponse.getName());
			menuItem.setPrice(apiResponse.getPrice());
			menuItem.setAvailable(apiResponse.isAvailable());
			menuItem.setRestaurantId(apiResponse.getRestaurant().getId());
			
			return menuItem;
	}
	
	public MenuItemResponse getMenuItemFallback(
            Long menuItemId,
            Throwable throwable
    ) {

		throw new RuntimeException("Menu Service is currently unavailable. Please try again later.");
    }

}
