package com.order.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.model.Product;

@FeignClient(name = "productCatalogService", url = "http://localhost:8080")

public interface CatalogFeignClient {
	@GetMapping("/products")
    ResponseEntity<List<Product>> getAllProducts();

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") long id);

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProductsByCategory(@RequestParam("category") String category);

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProductsByName(@RequestParam("name") String name);
}
