package com.mock.api.service;

import com.mock.api.model.Product;
import com.mock.api.dto.ProductDto;

public interface ProductStorageService {

    /**
     * Add Product to Storage
     *
     * @param productDto
     * @return
     */
    Product addProduct(ProductDto productDto);

    /**
     * Find Product By ProductId
     *
     * @param productId
     * @return
     */
    Product findByProductId(String productId);

}
