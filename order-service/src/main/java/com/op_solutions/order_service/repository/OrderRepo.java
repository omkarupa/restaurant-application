package com.op_solutions.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.op_solutions.order_service.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
