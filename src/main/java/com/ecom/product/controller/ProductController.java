package com.ecom.product.controller;

import com.ecom.product.dto.*;
import com.ecom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@PostMapping
	public ResponseEntity<ProductDto> create(@Valid @RequestBody CreateProductRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.getProduct(id));
	}

	@GetMapping
	public ResponseEntity<Page<ProductDto>> list(Pageable pageable) {
		return ResponseEntity.ok(service.listProducts(pageable));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody CreateProductRequest request) {
		return ResponseEntity.ok(service.updateProduct(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
