package com.meli.be_java_hisp_w16_g5.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products;

    public ProductRepository() {
        this.products = leerJson();
    }



    private List<Product> leerJson()
    {


        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:product.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> productList = null;
        try
        {
            productList=objectMapper.readValue(file,typeRef);
        }catch ( IOException e)
        {
            e.printStackTrace();
        }

        return productList;

    }

    @Override
    public Product getProductById(int productId) {
        return products.stream().filter(p-> p.getProductId()==productId).findFirst().orElse(null);
    }
}
