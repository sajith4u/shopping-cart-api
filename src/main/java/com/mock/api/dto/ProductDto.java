package com.mock.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String title;
    private float taxPercentage;
    private float discountPercentage;
    private BigDecimal price;
}
