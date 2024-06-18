package com.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Recommendation;
@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findAllByProduct_ProductName(String productName);

    void deleteById(Long id);

    Recommendation getOne(Long recommendationId);


}
