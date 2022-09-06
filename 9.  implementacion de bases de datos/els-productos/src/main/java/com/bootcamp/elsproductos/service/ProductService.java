package com.bootcamp.elsproductos.service;
import com.bootcamp.elsproductos.model.Product;
import com.bootcamp.elsproductos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    public void deleteProduct(Long id) {
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

    public void updateProduct(Long productId, Product updatedProduct) {
        updatedProduct.setId(productId);
        productRepository.save(updatedProduct);
    }
}
