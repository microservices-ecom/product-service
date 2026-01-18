package com.ecom.product.service;

import com.ecom.product.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	ProductDto createProduct(CreateProductRequest request);

	ProductDto updateProduct(Long id, CreateProductRequest request);

	ProductDto getProduct(Long id);

	Page<ProductDto> listProducts(Pageable pageable);

	void deleteProduct(Long id);
}
