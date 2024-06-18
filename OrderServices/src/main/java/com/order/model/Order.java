package com.order.model;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

    private Long userId;
    private Long productId;
    private int quantity;
    private BigDecimal totalPrice;
    private String orderStatus;
	public Order() {
		super();
	}
	public Order(Long orderId, Long userId, Long productId, int quantity, BigDecimal totalPrice, String orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    

}