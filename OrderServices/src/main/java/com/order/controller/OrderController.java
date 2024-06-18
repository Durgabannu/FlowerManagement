package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDTO;
import com.order.model.Order;
import com.order.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

	@PostMapping
	public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderDTO orderDTO) {
	    Order order = orderService.createOrder(orderDTO);
	    Map<String, Object> response = new HashMap<>();
	    response.put("orderId", order.getOrderId());
	    response.put("userId", order.getUserId());
	    response.put("productId", order.getProductId());
	    response.put("quantity", order.getQuantity());
	    response.put("totalPrice", order.getTotalPrice());
	    response.put("orderStatus", order.getOrderStatus());
	    return ResponseEntity.ok(response);
	}

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
