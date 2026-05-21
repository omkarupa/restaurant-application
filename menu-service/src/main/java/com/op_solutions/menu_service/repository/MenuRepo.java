package com.op_solutions.menu_service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.op_solutions.menu_service.model.MenuItem;

public interface MenuRepo extends JpaRepository<MenuItem, Long> {

	List<MenuItem> findByRestaurantId(Long restaurantId);

	@Query("SELECT m FROM MenuItem m WHERE LOWER(m.name) like LOWER(CONCAT('%',:name , '%'))")
	Page<MenuItem> findItemsByName(@Param("name") String name,Pageable pageable);

}
