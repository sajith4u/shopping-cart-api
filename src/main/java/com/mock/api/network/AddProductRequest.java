package com.mock.api.network;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProductRequest {
    private String name;
    private String title;
    private float taxPercentage;
    private float discountPercentage;
    private BigDecimal price;
}
