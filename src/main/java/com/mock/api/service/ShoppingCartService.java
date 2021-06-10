package com.mock.api.service;

import com.mock.api.model.ShoppingCart;
import com.mock.api.dto.ShoppingCartDto;

import java.util.Map;


public interface ShoppingCartService {

    ShoppingCart createCart(ShoppingCartDto shoppingCartDto);

    default void updateCart(String cartId, Map<String, Integer> newItems) {
        // Not Implemented Yet
    }

}
