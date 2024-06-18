package com.payment.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.RecommendationDTO;
import com.payment.model.Product;
import com.payment.model.Recommendation;
import com.payment.service.RecommendationService;


@RestController
@RequestMapping("/recom")
public class RecommentationController {
	 @Autowired
	    private RecommendationService recommendationService;

	 @PostMapping
		public ResponseEntity<Map<String, Object>> createRecommendation(@RequestBody RecommendationDTO recommendationDTO) {
			if (recommendationDTO == null) {
				return ResponseEntity.badRequest().build();
			}

			Product product = new Product();
			product.setFlowerType(recommendationDTO.getFlowerType());
			product.setColor(recommendationDTO.getColor());
			product.setPrice(recommendationDTO.getPrice());

			Recommendation recommendation = recommendationService.createRecommendation(recommendationDTO, product);

			if (recommendation == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

			Map<String, Object> response = new HashMap<>();
			response.put("recommendationId", recommendation.getId());
			response.put("userId", recommendation.getUserId()); // Fixed userId assignment
			response.put("productId", recommendation.getProduct().getId());
			response.put("rating", recommendation.getRating());

			return ResponseEntity.ok(response);
		}

		@GetMapping
		public ResponseEntity<List<Recommendation>> getAllRecommendations() {
			List<Recommendation> recommendations = recommendationService.getAllRecommendations();
			return new ResponseEntity<>(recommendations, HttpStatus.OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Map<String, Object>> getRecommendationById(@PathVariable("id") Long id) {
			Recommendation recommendation = recommendationService.getRecommendationById(id);
			if (recommendation == null) {
				return ResponseEntity.notFound().build();
			}

			Map<String, Object> response = new HashMap<>();
			response.put("recommendationId", recommendation.getId());
			response.put("userId", recommendation.getUserId());
			response.put("productId", recommendation.getProduct().getId());
			response.put("rating", recommendation.getRating());

			Object ratings = recommendationService.getUserRatings().get(recommendation.getUserId());
			response.put("ratings", ratings != null ? ratings : Collections.emptyList());

			return ResponseEntity.ok(response);
		}

		
	}