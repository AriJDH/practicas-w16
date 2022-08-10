package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {

  List<Product> products = new ArrayList<Product>();

  @PostConstruct
  private void loadData() {
    products.add(new Product(100, "Silla gamer", "Gamer", "Racer", "Negro", "note 1"));
    products.add(new Product(200, "Nevera", "Linea blanca", "Samsung", "Blanca", "note 2"));

  }

  @Override
  public Product createProduct(ProductCreateDTO productDTO) {

   Boolean SuccessValidate = validateFields(productDTO);
    if (!SuccessValidate) return null;

    Product product = new Product(productDTO.getProductId(),
            productDTO.getProductName(),
            productDTO.getType(),
            productDTO.getBrand(),
            productDTO.getColor(),
            productDTO.getNotes());


    products.add(product);
    return product;

  }
  private Boolean validateFields(ProductCreateDTO productDTO) {

    return productDTO.getProductId() != null &&
            productDTO.getProductName() != null &&
            productDTO.getType() != null &&
            productDTO.getBrand() != null &&
            productDTO.getColor() != null &&
            productDTO.getNotes() != null;
  }


}


