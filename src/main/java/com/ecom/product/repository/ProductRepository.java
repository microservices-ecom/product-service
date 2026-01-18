package com.ecom.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
