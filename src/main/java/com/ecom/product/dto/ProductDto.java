package com.ecom.product.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer quantity;
	private Long categoryId;
	private Boolean active;
}
