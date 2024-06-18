package com.payment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "users")
public class User {
	 @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column (name = "user_name")
	    private String userName;

	    @OneToMany (mappedBy = "user")
	    @JsonIgnore
	    private List<Recommendation> recommendations;
	    
	    public User() {
	    	
	    }

	    public User(String userName, List<Recommendation> recomendations) {
	        this.userName = userName;
	        this.recommendations = recomendations;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public List<Recommendation> getRecomendations() {
	        return recommendations;
	    }

	    public void setRecomendations(List<Recommendation> recomendations) {
	        this.recommendations = recomendations;
	    }

		public Long getId() {
			// TODO Auto-generated method stub
			return null;
		}
	
}
