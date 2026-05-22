package com.op_solutions.order_service.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.op_solutions.order_service.dto.MenuItemResponse;
import com.op_solutions.order_service.model.Order;
import com.op_solutions.order_service.model.OrderItem;
import com.op_solutions.order_service.repository.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final MenuItemService menuItemService;
	
	private final OrderRepo orderRepository;

	public Order placeOrder(Order order)
	{
		
		try {
		
		List<OrderItem> orderItems = order.getOrderItems();
		List<MenuItemResponse> menuItemsList = orderItems.stream().map(orderItem -> orderItem.getMenuItemId()).map(menuItemId -> menuItemService.getMenuItemById(menuItemId)).collect(Collectors.toList());
		
		Map<Long, MenuItemResponse> menuItemMap = menuItemsList.stream().collect(Collectors.toMap(MenuItemResponse::getId, menuItem -> menuItem));
		
		orderItems.forEach(orderItem -> {
			MenuItemResponse menuItem = menuItemMap.get(orderItem.getMenuItemId());
			orderItem.setItemName(menuItem.getName());
			orderItem.setPrice(BigDecimal.valueOf( menuItem.getPrice()));
			orderItem.setTotalPrice(BigDecimal.valueOf(menuItem.getPrice()).multiply(BigDecimal.valueOf(orderItem.getQuantity())));
			orderItem.setOrder(order);
		});
		
		order.setTotalAmount(getTotalAmount(orderItems));
		
		order.setOrderStatus("PLACED");
		return	orderRepository.save(order);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("Failed to place order: " + e.getMessage());
		}
		
	}
	
	
	public BigDecimal getTotalAmount(List<OrderItem> orderItems)
	{
		return orderItems.stream()
				.map(OrderItem::getTotalPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	
	
	
}
