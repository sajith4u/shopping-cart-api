package com.mock.api.service;

import com.mock.api.model.ShoppingCart;
import com.mock.api.network.CreateCartRequest;

import java.util.Map;


public interface ShoppingCartService {

    ShoppingCart createCart(CreateCartRequest createCartRequest);

    default void updateCart(String cartId, Map<String, Integer> newItems) {
        // Not Implemented Yet
    }

}
