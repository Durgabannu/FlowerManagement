package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

}
