package com.payment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.payment.dto.RecommendationDTO;
import com.payment.model.Product;
import com.payment.model.Recommendation;


@Service
public class RecommendationService {
	private Map<Integer, List<Integer>> userRatings;

    public RecommendationService() {
        userRatings = new HashMap<>();
        userRatings.put(1, List.of(2, 3, 5));
        userRatings.put(2, List.of(1, 3, 4));
        userRatings.put(3, List.of(1, 2, 4));
        userRatings.put(4, List.of(2, 5));
    }

    public Map<Integer, List<Integer>> getUserRatings() {
        return userRatings;
    }

    public Recommendation createRecommendation(RecommendationDTO recommendationDTO, Product product) {
       
        Recommendation recommendation = new Recommendation();
        recommendation.setId(1L); 
        recommendation.setId(recommendationDTO.getUserId());
        recommendation.setProduct(product);
        recommendation.setRating(recommendationDTO.getRating());
        return recommendation;
    }
    public Map<Integer, List<Integer>> getUserRatings1() {
        return userRatings;
    }

    public List<Integer> getRatingsByProductId(int productId) {
        List<Integer> ratings = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : userRatings.entrySet()) {
            if (entry.getValue().contains(productId)) {
                ratings.add(entry.getKey());
            }
        }
        return ratings;
    }

	public List<Recommendation> getAllRecommendations() {
		// TODO Auto-generated method stub
		return null;
	}

	public Recommendation getRecommendationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}