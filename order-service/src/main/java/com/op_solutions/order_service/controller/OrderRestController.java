package com.op_solutions.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.op_solutions.order_service.model.Order;
import com.op_solutions.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderRestController {
	
	private final OrderService orderService;

	@PostMapping("")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order)
	{
		return ResponseEntity.ok(orderService.placeOrder(order));
	}
	
}
