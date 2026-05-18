package com.op_solutions.menu_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.op_solutions.menu_service.model.MenuItem;
import com.op_solutions.menu_service.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menuItem")
public class MenuItemRestController {
	
	private final MenuService service;
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<List<MenuItem>> getMenuList(@PathVariable Long restaurantId)
	{
		return ResponseEntity.ok(service.getMenuList(restaurantId));
	}

}
