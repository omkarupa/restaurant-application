package com.op_solutions.menu_service.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.op_solutions.menu_service.model.MenuItem;
import com.op_solutions.menu_service.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menuItems")
public class MenuItemRestController {
	
	private final MenuService service;

	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<MenuItem>> getMenuList(@PathVariable Long restaurantId)
	{
		return ResponseEntity.ok(service.getMenuList(restaurantId));
	}
	@GetMapping("/{menuItemId}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable Long menuItemId)
	{
		return ResponseEntity.ok(service.getMenuItem(menuItemId));
	}
	
	@GetMapping("/itemName/{name}")
	public ResponseEntity<Page<MenuItem>> getMenuItemByName(@PathVariable String name ,@RequestParam(defaultValue = "0") int page  ,@RequestParam(defaultValue = "10") int size)
	{
		return ResponseEntity.ok(service.getMenuItemByName(name,page,size));
	}
	

}
