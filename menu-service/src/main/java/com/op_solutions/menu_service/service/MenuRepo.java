package com.op_solutions.menu_service.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.op_solutions.menu_service.model.MenuItem;

public interface MenuRepo extends JpaRepository<MenuItem, Long> {

	List<MenuItem> findByRestaurantId(Long restaurantId);

}
