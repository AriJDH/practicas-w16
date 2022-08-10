package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    private final ModelMapper mapper ;
    public ProductService() {
        mapper =  new ModelMapper();
    }

    @Override
    public ProductDTO getProductById(Integer idProduct) {
        Product product = iProductRepository.getProductById(idProduct);
        return mapper.map(product, ProductDTO.class);
    }
}
