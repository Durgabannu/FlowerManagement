package com.payment.dto;

public class PaymentRequestDTO {
	
	private double amount;
    private String currency;
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    
	public PaymentRequestDTO() {
		super();
	}

	public PaymentRequestDTO(double amount, String currency, String cardNumber, String expiryDate, int cvv) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	

}
