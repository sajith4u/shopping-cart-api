package com.mock.api.service.impl;

import com.mock.api.model.Product;
import com.mock.api.dto.ProductDto;
import com.mock.api.service.ProductStorageService;
import com.mock.api.util.ApiError;
import com.mock.api.util.CustomerException;
import com.mock.api.util.ProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductStorageServiceImpl implements ProductStorageService {

    List<Product> products = new ArrayList<>();

    @Override
    public Product addProduct(ProductDto productDto) {
        Product newProduct = Product.builder().name(productDto.getName())
                .discountPercentage(productDto.getDiscountPercentage())
                .productId(UUID.randomUUID().toString())
                .taxPercentage(productDto.getTaxPercentage())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .build();

        boolean isProductAlreadyAvailable = products.contains(newProduct);
        if (isProductAlreadyAvailable) {
            throw new ProductException(ApiError.PRODUCT_ALREADY_AVAILABLE);
        }

        newProduct(newProduct);
        return newProduct;
    }

    /**
     * Concurrent Product Update issue fixed using synchronized blcok
     *
     * @param newProduct
     */
    private synchronized void newProduct(Product newProduct) {
        products.add(newProduct);
    }


    @Override
    public Product findByProductId(String productId) {
        Optional<Product> productInfo = products.stream().filter(user -> user.getProductId().equals(productId)).findAny();
        if (!productInfo.isPresent()) {
            throw new CustomerException(ApiError.PRODUCT_NOT_AVAILABLE);
        }
        return productInfo.get();
    }
}
