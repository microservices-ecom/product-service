package com.ecom.product.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateProductRequest {

	@NotBlank
	private String name;

	private String description;

	@NotNull
	@Positive
	private BigDecimal price;

	@NotNull
	@Min(0)
	private Integer quantity;

	@NotNull
	private Long categoryId;
	
	private Boolean active = true;
}
