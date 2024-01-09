package com.myown.shop.service;

import com.myown.shop.dto.ProductDto;
import com.myown.shop.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> showAllProducts();

    ProductDto updateProduct(Long id, ProductDto productDto) throws ResourceNotFoundException;

    void removeProduct(Long id) throws ResourceNotFoundException;
}
