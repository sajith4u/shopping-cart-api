package com.mock.api.network;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCartRequest {
    private String customerId;

    // productId with quantity
    private Map<String, Integer> items;
}
