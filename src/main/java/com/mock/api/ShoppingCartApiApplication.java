package com.mock.api;

import com.mock.api.model.Customer;
import com.mock.api.model.Product;
import com.mock.api.model.ShoppingCart;
import com.mock.api.network.AddCustomerRequest;
import com.mock.api.network.AddProductRequest;
import com.mock.api.network.CreateCartRequest;
import com.mock.api.service.CustomerService;
import com.mock.api.service.ProductStorageService;
import com.mock.api.service.ShoppingCartService;
import com.mock.api.service.impl.CustomerServiceImpl;
import com.mock.api.service.impl.ProductStorageServiceImpl;
import com.mock.api.service.impl.ShoppingCartServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartApiApplication {

    public static void main(String[] args) {

        // Create Two Customers
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer1 = customerService.addCustomer(new AddCustomerRequest("sajith"));
        Customer customer2 = customerService.addCustomer(new AddCustomerRequest("khalid"));


        // Add Products to System

        ProductStorageService productStorageService = new ProductStorageServiceImpl();

        AddProductRequest saveProduct1 = AddProductRequest.builder().name("Samsung Odyssey CRG9")
                .discountPercentage(5.5f)
                .price(BigDecimal.valueOf(150000))
                .taxPercentage(10)
                .title("Samsung Monitor")
                .build();

        AddProductRequest saveProduct2 = AddProductRequest.builder().name("ASUS ROG Strix")
                .discountPercentage(7)
                .price(BigDecimal.valueOf(200000))
                .taxPercentage(15)
                .title("Asus Monitor")
                .build();

        Product product1 = productStorageService.addProduct(saveProduct1);
        Product product2 = productStorageService.addProduct(saveProduct2);


        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(customerService, productStorageService);


        // Test Case 1

        Map<String, Integer> selectedProducts = new HashMap<>();
        selectedProducts.put(product1.getProductId(), 2);

        CreateCartRequest createCartRequest = CreateCartRequest.builder().customerId(customer1.getId()).items(selectedProducts).build();

        ShoppingCart customerCart1 = shoppingCartService.createCart(createCartRequest);

        customerCart1.calculateCost();
        System.out.println(customerCart1.viewSummary());
        System.out.println(customerCart1.getProducts());
        System.out.println("\n");


        // Test Case 2
        //  Add Product1 , 2 Items & Product2 , 3 Items


        Map<String, Integer> customerTwoSelectedItems = new HashMap<>();
        customerTwoSelectedItems.put(product1.getProductId(), 2);
        customerTwoSelectedItems.put(product2.getProductId(), 3);

        CreateCartRequest customerTwoCartRequest = CreateCartRequest.builder().customerId(customer2.getId()).items(customerTwoSelectedItems).build();

        ShoppingCart customerCart2 = shoppingCartService.createCart(customerTwoCartRequest);

        customerCart2.calculateCost();

        System.out.println(customerCart2.viewSummary());
        System.out.println(customerCart2.getProducts());

    }
}
