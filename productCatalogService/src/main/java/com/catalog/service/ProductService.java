package com.catalog.service;

import java.util.List;

import com.catalog.model.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product getProductById(Long id);

	public void deleteProduct(Long id);

	public List<Product> getAllProduct();

	public List<Product> getAllProductByCategory(String category);

	public List<Product> getAllProductsByName(String name);

	public void updateProduct(Product updatedProduct);


}
