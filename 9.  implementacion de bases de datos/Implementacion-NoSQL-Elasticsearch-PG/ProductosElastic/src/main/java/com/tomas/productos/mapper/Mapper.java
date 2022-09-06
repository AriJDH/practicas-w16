package com.tomas.productos.mapper;

import com.tomas.productos.dto.ProductDTO;
import com.tomas.productos.dto.UpdateProductDto;
import com.tomas.productos.model.Product;
import org.springframework.stereotype.Component;


@Component
public class Mapper {

    public Product productDtoToProductEntity(ProductDTO productDto){

            Product product = new Product();
            product.setName(productDto.getName());
            product.setType(productDto.getType());
            product.setAmount(productDto.getAmount());
            product.setPriceCost(productDto.getPriceCost());
            product.setPriceSale(productDto.getPriceSale());

            return product;

    }

    public Product updateProductDtoToProductEntity(UpdateProductDto updateProduct) {

        Product product = new Product();
        product.setId(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setType(updateProduct.getType());
        product.setAmount(updateProduct.getAmount());
        product.setPriceCost(updateProduct.getPriceCost());
        product.setPriceSale(updateProduct.getPriceSale());

        return product;

    }

}
