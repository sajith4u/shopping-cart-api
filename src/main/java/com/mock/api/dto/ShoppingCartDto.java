package com.mock.api.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDto {
    private String customerId;

    // productId with quantity
    private Map<String, Integer> items;
}
