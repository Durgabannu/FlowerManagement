package com.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.model.Product;
import com.catalog.service.ProductService;

@RestController
public class Productcontroller {
	 @Autowired
	    private ProductService productService;
	 @GetMapping(value = "/products")
	 public ResponseEntity<List<Product>> getAllProducts() {
	     List<Product> products = productService.getAllProduct();
	     if (!products.isEmpty()) {
	         return ResponseEntity.ok(products);
	     }
	     return ResponseEntity.notFound().build();
	 }

	 @GetMapping(value = "/products", params = "category")
	 public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam("category") String category) {
	     List<Product> products = productService.getAllProductByCategory(category);
	     if (!products.isEmpty()) {
	         return ResponseEntity.ok(products);
	     }
	     return ResponseEntity.notFound().build();
	 }

	 @GetMapping(value = "/products/{id}")
	 public ResponseEntity<Product> getOneProductById(@PathVariable("id") long id) {
	     Product product = productService.getProductById(id);
	     if (product != null) {
	         return ResponseEntity.ok(product);
	     }
	     return ResponseEntity.notFound().build();
	 }

	 @GetMapping(value = "/products", params = "name")
	 public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam("name") String name) {
	     List<Product> products = productService.getAllProductsByName(name);
	     if (!products.isEmpty()) {
	         return ResponseEntity.ok(products);
	     }
	     return ResponseEntity.notFound().build();
	 }

 
}
