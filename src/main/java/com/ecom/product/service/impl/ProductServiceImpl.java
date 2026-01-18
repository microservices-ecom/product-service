package com.ecom.product.service.impl;

import com.ecom.product.dto.*;
import com.ecom.product.exception.ProductNotFoundException;
import com.ecom.product.mapper.ProductMapper;
import com.ecom.product.model.Product;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	private final ProductMapper mapper;

	@Override
	public ProductDto createProduct(CreateProductRequest request) {
		Product product = Product.builder()
		        .name(request.getName())
		        .description(request.getDescription())
		        .price(request.getPrice())
		        .quantity(request.getQuantity())
		        .categoryId(request.getCategoryId())
		        .active(true)  // set default here
		        .build();

		return mapper.toDto(repository.save(product));
	}

	@Override
	public ProductDto updateProduct(Long id, CreateProductRequest request) {
		Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		mapper.updateEntity(request, product);
		return mapper.toDto(repository.save(product));
	}

	@Override
	public ProductDto getProduct(Long id) {
		return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@Override
	public Page<ProductDto> listProducts(Pageable pageable) {
		return repository.findAll(pageable).map(mapper::toDto);
	}

	@Override
	public void deleteProduct(Long id) {
		if (!repository.existsById(id))
			throw new ProductNotFoundException(id);
		repository.deleteById(id);
	}
}
