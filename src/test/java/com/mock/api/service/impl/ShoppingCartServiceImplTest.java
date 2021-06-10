package com.mock.api.service.impl;

import com.mock.api.model.Customer;
import com.mock.api.model.Product;
import com.mock.api.model.ShoppingCart;
import com.mock.api.dto.CustomerDto;
import com.mock.api.dto.ProductDto;
import com.mock.api.dto.ShoppingCartDto;
import com.mock.api.service.CustomerService;
import com.mock.api.service.ProductStorageService;
import com.mock.api.service.ShoppingCartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShoppingCartServiceImplTest {


    @Test
    @DisplayName("Test Create Shopping Cart")
    void testCreateShoppingCart() {
        ProductStorageService productStorageService = new ProductStorageServiceImpl();

        ProductDto product = ProductDto.builder().name("Samsung Odyssey CRG9")
                .discountPercentage(0)
                .price(BigDecimal.valueOf(10000))
                .taxPercentage(10)
                .title("Samsung Monitor")
                .build();

        // Save New product
        Product savedItem = productStorageService.addProduct(product);


        // Add New Customer
        CustomerService customerService = new CustomerServiceImpl();
        Customer customerDetails = customerService.addCustomer(new CustomerDto("Sajith"));

        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(customerService, productStorageService);

        Map<String, Integer> customerTwoSelectedItems = new HashMap<>();
        customerTwoSelectedItems.put(savedItem.getProductId(), 1);

        ShoppingCartDto shoppingCartAddRequest = ShoppingCartDto.builder()
                .customerId(customerDetails.getId())
                .items(customerTwoSelectedItems)
                .build();

        // Create Cart for Customer
        ShoppingCart cart = shoppingCartService.createCart(shoppingCartAddRequest);

        // Calculate Cart Summary
        cart.calculateCost();

        assertNotNull(cart);

        // Total Cost = 10000 +  Tax = 10000* 10%, 4000(shipping cost + vat)
        assertEquals(BigDecimal.valueOf(15000), cart.getFinalCost());
    }
}