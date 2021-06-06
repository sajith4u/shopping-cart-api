package com.mock.api.service.impl;

import com.mock.api.model.Customer;
import com.mock.api.model.Product;
import com.mock.api.model.ShoppingCart;
import com.mock.api.network.CreateCartRequest;
import com.mock.api.service.CustomerService;
import com.mock.api.service.ProductStorageService;
import com.mock.api.service.ShoppingCartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private CustomerService customerService;
    private ProductStorageService productStorageService;

    // Assumption : TOTAL SHIPPING COST for Shopping Cart
    private static BigDecimal SHIPPING_COST = BigDecimal.valueOf(2500);

    // Assumption : TOTAL VAT for Shopping Cart
    private static BigDecimal TOTAL_VAT = BigDecimal.valueOf(1500);

    private List<ShoppingCart> customerShoppingCarts = new ArrayList<>();

    public ShoppingCartServiceImpl(CustomerService customerService, ProductStorageService productStorageService) {
        this.customerService = customerService;
        this.productStorageService = productStorageService;
    }

    @Override
    public ShoppingCart createCart(CreateCartRequest createCartRequest) {

        ConcurrentHashMap<Product, Integer> products = new ConcurrentHashMap<>();

        for (Map.Entry<String, Integer> entry : createCartRequest.getItems().entrySet()) {
            Product product = productStorageService.findByProductId(entry.getKey());
            products.merge(product, entry.getValue(), Integer::sum);
        }

        Customer customer = customerService.findCustomer(createCartRequest.getCustomerId());

        ShoppingCart cart = ShoppingCart.builder()
                .products(products)
                .totalVat(TOTAL_VAT)
                .shippingCost(SHIPPING_COST)
                .customer(customer)
                .cartId(UUID.randomUUID().toString())
                .build();

        customerShoppingCarts.add(cart);
        return cart;
    }

}
