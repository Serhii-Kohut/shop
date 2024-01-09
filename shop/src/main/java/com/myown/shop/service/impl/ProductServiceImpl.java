package com.myown.shop.service.impl;

import com.myown.shop.dto.ProductDto;
import com.myown.shop.entity.Product;
import com.myown.shop.exception.ResourceNotFoundException;
import com.myown.shop.mapper.ProductMapper;
import com.myown.shop.repository.ProductRepository;
import com.myown.shop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    @Transactional
    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToEntity(productDto);
        Product savedProduct = productRepository.save(product);

        log.info("Product {} was added", product.getItemName());

        return productMapper.productToDto(savedProduct);
    }

    @Transactional
    @Override
    public List<ProductDto> showAllProducts() {
        List<Product> products = productRepository.findAll();

        log.info("List of products was formed.");

        return products.stream()
                .map(productMapper::productToDto)
                .toList();
    }

    @Transactional
    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found!"));

            product.setId(id);
            Product updatedProduct = productRepository.save(product);

            log.info("Product {} was updated", product.getItemName());

            return productMapper.productToDto(updatedProduct);
    }

    @Transactional
    @Override
    public void removeProduct(Long id) throws ResourceNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found!"));

        productRepository.delete(existingProduct);

        log.info("Product {} was removed", existingProduct.getItemName());
    }
}
