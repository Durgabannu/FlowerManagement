package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catalog.model.Product;
import com.catalog.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
private ProductRepository productRepository;

@Override
public List<Product> getAllProduct() {
    return productRepository.findAll();
}

@Override
public List<Product> getAllProductByCategory(String category) {
    return productRepository.findAllByCategory(category);
}

@Override
public Product getProductById(Long id) {
    Optional<Product> productOptional = productRepository.findById(id);
    return productOptional.orElse(null);
}


@Override
public List<Product> getAllProductsByName(String name) {
    return productRepository.findAllByProductName(name);
}

@Override
public Product addProduct(Product product) {
    return productRepository.save(product);
}

@Override
public void deleteProduct(Long productId) {
    productRepository.deleteById(productId);
}

@Override
public void updateProduct(Product updatedProduct) {
	// TODO Auto-generated method stub
	
}
}
