package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Order;

@Repository
public interface orderRepository extends JpaRepository<Order, Long>{

	

}
