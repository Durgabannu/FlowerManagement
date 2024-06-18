package com.payment.service;


import org.springframework.stereotype.Service;

import com.payment.dto.PaymentRequestDTO;


@Service
public class PaymentService {
	
        
	 public String processPayment(PaymentRequestDTO paymentRequest) {
	        if (paymentRequest.getAmount() > 0 && paymentRequest.getCurrency() != null && !((String) paymentRequest.getCurrency()).isEmpty() && 
	            paymentRequest.getCardNumber() != null && !((String) paymentRequest.getCardNumber()).isEmpty()) {
	            
	            return "Payment successful";
	        } else {
	            return "Payment failed";
	        }
}

	public String processPayment(double amount, String currency, String cardNumber, String expiryDate, int cvv) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
