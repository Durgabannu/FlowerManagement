package com.catalog.model;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "products")
public class Product {
	
		@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column (name = "product_name")

	private String productName;

	@Column (name = "price")
	private BigDecimal price;

	@Column (name = "description")
	private String description;

	@Column (name = "category")
	private String category;

	@Column (name = "availability")
	private int availability;

	public Product() {

	}

	public Long getproductId() {
		return productId;
	}

	public void setproductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String discription) {
		this.description = discription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	} 
	}


