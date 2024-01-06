package com.myown.shop.service.impl;

import com.myown.shop.dto.ProductDto;
import com.myown.shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> showAllProducts() {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void removeProduct(ProductDto productDto) {

    }
}
