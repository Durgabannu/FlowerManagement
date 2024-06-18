package com.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.PaymentRequestDTO;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequestDTO paymentRequest) {
        String paymentStatus = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentStatus);
    }


}
