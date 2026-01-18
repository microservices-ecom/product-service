package com.ecom.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.ecom.product.dto.*;
import com.ecom.product.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toEntity(CreateProductRequest request);

	ProductDto toDto(Product product);

	void updateEntity(CreateProductRequest request, @MappingTarget Product product);
}
