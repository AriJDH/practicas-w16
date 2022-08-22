package com.meli.be_java_hisp_w16_g5.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Clase ProductRepository
 */
@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products;

    /**
     * Constructor
     */
    public ProductRepository() {

            this.products = this.leerJson();
    }

    /**
     * Metodo para leer la data que existe en recursos
     * @return List<Product>
     */
    private List<Product> leerJson() {
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

    /**
     * Metodo para obtener producto por id
     * @param productId
     * @return Product
     */
    @Override
    public Product getProductById(Integer productId) {
        return products.stream().filter(p-> p.getProductId()==productId).findFirst().orElse(null);
    }

    @Override
    public void save(List<Product> product) {
        this.products = product;
    }
}
