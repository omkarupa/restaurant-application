package com.op_solutions.menu_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.op_solutions.menu_service.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

}
