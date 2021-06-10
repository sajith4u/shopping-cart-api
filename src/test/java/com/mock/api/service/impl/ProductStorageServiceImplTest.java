package com.mock.api.service.impl;

import com.mock.api.model.Product;
import com.mock.api.dto.ProductDto;
import com.mock.api.service.ProductStorageService;
import com.mock.api.util.ProductException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Product Service")
class ProductStorageServiceImplTest {

    @Test
    @DisplayName("Test Add product")
    void testAddProduct() {
        ProductStorageService productStorageService = new ProductStorageServiceImpl();

        ProductDto product = ProductDto.builder().name("Samsung Odyssey CRG9")
                .discountPercentage(5)
                .price(BigDecimal.valueOf(150000))
                .taxPercentage(10)
                .title("Samsung Monitor")
                .build();

        Product savedItem = productStorageService.addProduct(product);

        Product selectedItem = productStorageService.findByProductId(savedItem.getProductId());
        assertNotNull(selectedItem);
        assertEquals("Samsung Monitor",selectedItem.getTitle());
    }


    @Test
    @DisplayName("Test Duplicate Product")
    void testDuplicateProduct() {
        ProductStorageService productStorageService = new ProductStorageServiceImpl();

        ProductDto product = ProductDto.builder().name("Samsung Odyssey CRG9")
                .discountPercentage(5)
                .price(BigDecimal.valueOf(150000))
                .taxPercentage(10)
                .title("Samsung Monitor")
                .build();

        productStorageService.addProduct(product);

        assertThrows(ProductException.class, () -> {
            productStorageService.addProduct(product);
        });
    }

}