package com.myown.shop.service;

import com.myown.shop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> showAllProducts();

    ProductDto updateProduct(Long id, ProductDto productDto);

    void removeProduct(ProductDto productDto);
}
