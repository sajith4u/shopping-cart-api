package com.mock.api.service;

import com.mock.api.model.Product;
import com.mock.api.network.AddProductRequest;

public interface ProductStorageService {

    /**
     * Add Product to Storage
     *
     * @param addProductRequest
     * @return
     */
    Product addProduct(AddProductRequest addProductRequest);

    /**
     * Find Product By ProductId
     *
     * @param productId
     * @return
     */
    Product findByProductId(String productId);

}
