package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderDTO;
import com.order.model.Order;
import com.order.repository.OrderRepository;

import jakarta.transaction.Transactional;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        // Convert OrderDTO to Order entity
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setProductId(orderDTO.getProductId());
        order.setQuantity(orderDTO.getQuantity());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setOrderStatus(orderDTO.getOrderStatus());

        // Save the order
        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

	
}
