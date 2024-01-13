package com.myown.shop.service;

import com.myown.shop.dto.ProductDto;
import com.myown.shop.entity.Product;
import com.myown.shop.exception.ResourceNotFoundException;
import com.myown.shop.mapper.ProductMapper;
import com.myown.shop.repository.ProductRepository;
import com.myown.shop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        when(productMapper.productDtoToEntity(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.productToDto(product)).thenReturn(productDto);

        ProductDto result = productService.addProduct(productDto);

        assertEquals(productDto, result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testShowAllProducts() {
        Product product = new Product();
        ProductDto productDto = new ProductDto();
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.productToDto(product)).thenReturn(productDto);

        List<ProductDto> result = productService.showAllProducts();

        assertEquals(1, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateProduct() throws ResourceNotFoundException {
        Long id = 1L;
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        when(productMapper.productDtoToEntity(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.productToDto(product)).thenReturn(productDto);

        ProductDto result = productService.updateProduct(id, productDto);

        assertEquals(productDto, result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testRemoveProduct() throws ResourceNotFoundException {
        Long id = 1L;
        Product product = new Product();
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        productService.removeProduct(id);

        verify(productRepository, times(1)).delete(any(Product.class));
    }

}
