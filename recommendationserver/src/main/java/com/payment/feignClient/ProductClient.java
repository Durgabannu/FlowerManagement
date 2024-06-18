package com.payment.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payment.model.Product;



@FeignClient (name = "productCatalogService", url = "http://localhost:8080")

public interface ProductClient {
	@GetMapping("/recommendations/collaborative/{userId}")
    List<Product> getCollaborativeFilteringRecommendations(@PathVariable("userId") Long userId);
}


