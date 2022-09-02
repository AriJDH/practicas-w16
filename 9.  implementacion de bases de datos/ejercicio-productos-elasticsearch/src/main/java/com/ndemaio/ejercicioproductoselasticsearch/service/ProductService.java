package com.ndemaio.ejercicioproductoselasticsearch.service;

import com.ndemaio.ejercicioproductoselasticsearch.model.Product;
import com.ndemaio.ejercicioproductoselasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts() {
        var products = productRepository.findAll();
        ArrayList<Product> result = new ArrayList();
        products.forEach(product -> result.add(product));
        return result;
    }

    public void updateProductWithId(Long anIdToUpdate, Product updatedProduct) {
        updatedProduct.setId(anIdToUpdate);
        productRepository.save(updatedProduct);
    }
}
