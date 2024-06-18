package com.order.service;

import java.util.List;

import com.order.dto.OrderDTO;
import com.order.model.Order;

public interface OrderService {

	List<Order> getAllOrders();

	Order createOrder(OrderDTO orderDTO);

	Order getOrderById(Long id);

	void deleteOrder(Long id);

}
