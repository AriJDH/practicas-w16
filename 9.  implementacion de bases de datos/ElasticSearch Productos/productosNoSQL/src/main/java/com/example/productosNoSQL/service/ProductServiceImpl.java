package com.example.productosNoSQL.service;

import com.example.productosNoSQL.dto.ProductDto;
import com.example.productosNoSQL.dto.StatusDto;
import com.example.productosNoSQL.entity.Product;
import com.example.productosNoSQL.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductRepository productRepository;

    private ModelMapper modelMapper;

    public ProductServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ProductDto> getAllProduct() {
        Iterable<Product> products= productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public StatusDto createProduct(List<ProductDto> productDtoList) {
        List<Product> products = productDtoList.stream()
                .map(productDto -> modelMapper.map(productDto,Product.class))
                .collect(Collectors.toList());
        productRepository.saveAll(products);
        return new StatusDto("Products created");
    }

    @Override
    public ProductDto updatedProduct(ProductDto productDto) {
        Product product = productRepository.save(modelMapper.map(productDto,Product.class));
        ProductDto productDtoUpdated = modelMapper.map(product,ProductDto.class);
        return productDtoUpdated;
    }
}
