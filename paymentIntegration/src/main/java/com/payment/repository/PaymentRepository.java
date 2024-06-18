package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.model.PaymentRequest;

public interface PaymentRepository extends JpaRepository<PaymentRequest, Long>{

}
