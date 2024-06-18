package com.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.model.Product;
import com.catalog.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private ProductService productService;
    
	@PostMapping(value = "/products")
	private ResponseEntity<Product> addProduct(@RequestBody Product product, HttpServletRequest request) {
	    if (product != null) {
	        try {
	            productService.addProduct(product);
	            return ResponseEntity.status(HttpStatus.CREATED).body(product);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    return ResponseEntity.badRequest().build();
	}
	@PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable String productId, @RequestBody Product product) {
    	return ResponseEntity.status(HttpStatus.OK)
                .body("Product  " + productId + " updated successfully");
              }

	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
	    Product product = productService.getProductById(id);
	    if (product != null) {
	        try {
	            productService.deleteProduct(id);
	            return ResponseEntity.ok("Product " + id + " deleted successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    return ResponseEntity.notFound().build();
	}

}
