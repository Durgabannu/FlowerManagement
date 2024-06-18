package com.payment.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "recommendation")
public class Recommendation {
   
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "rating")
	    private int rating;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "product_id")
	    private Product product;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private User user;

		public Recommendation() {
			super();
		}

		public Recommendation(Long id, int rating, Product product, User user) {
			super();
			this.id = id;
			this.rating = rating;
			this.product = product;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Object getUserId() {
			// TODO Auto-generated method stub
			return null;
		}
	    
}