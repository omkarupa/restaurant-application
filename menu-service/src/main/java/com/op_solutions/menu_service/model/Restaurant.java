package com.op_solutions.menu_service.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length = 100)
	private String name;
	
	@Column(name = "is_pure_veg",nullable = false)
	private boolean isPureVeg;
	
	@Column(name="is_active",nullable = false)
	private boolean isActive;
	
	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL )
	private List<MenuItem> menuItems = new ArrayList();

}
