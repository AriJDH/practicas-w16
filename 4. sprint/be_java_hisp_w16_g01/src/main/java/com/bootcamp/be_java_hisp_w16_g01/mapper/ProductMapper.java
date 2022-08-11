package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.ProductDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;

public class ProductMapper {
    public ProductDto toDto(Product product){
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}
