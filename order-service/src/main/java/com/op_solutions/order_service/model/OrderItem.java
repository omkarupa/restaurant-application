package com.op_solutions.order_service.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long menuItemId;
	
	private int quantity;
	
	private String itemName;
	
	private BigDecimal price;
	
	private BigDecimal totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@JsonIgnore
	private Order order;
	
	
}
