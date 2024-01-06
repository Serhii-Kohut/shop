package com.myown.shop.mapper;

import com.myown.shop.dto.ProductDto;
import com.myown.shop.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto productToDto(Product product);
}
