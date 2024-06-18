package com.payment.dto;

public class RecommendationDTO {
	private Long userId;
    private Long productId;
    private int rating;
    private String flowerType;
    private String color;
    private double price;

    public RecommendationDTO() {
    }

    public RecommendationDTO(Long userId, Long productId, int rating, String flowerType, String color, double price) {
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
        this.flowerType = flowerType;
        this.color = color;
        this.price = price;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
	