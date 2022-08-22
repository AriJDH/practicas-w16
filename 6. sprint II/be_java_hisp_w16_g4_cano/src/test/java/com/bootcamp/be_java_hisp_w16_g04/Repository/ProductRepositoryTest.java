package com.bootcamp.be_java_hisp_w16_g04.Repository;

import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.ProductRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IProductRepository iProductRepository;


    @Test
    public void getProductByIdTest() {
        List<Product> result = TestUtilsGenerator.getProducts();
        productRepository.setProducts(result);

        Product product = result.get(0);

        Product resultRepository = productRepository.getProductById(result.get(0).getProductId());

        Assertions.assertEquals(product, resultRepository);
    }
}
