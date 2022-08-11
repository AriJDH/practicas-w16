package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreatePromoDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

  List<Product> products = new ArrayList<Product>();

  @PostConstruct
  private void loadData() {
    products.add(new Product(100, "Silla gamer", "Gamer", "Racer", "Negro", "usado"));
    products.add(new Product(200, "Nevera", "Linea blanca", "Samsung", "Blanca", "usado"));
    products.add(new Product(300, "Lavadora", "Linea blanca", "Samsung", "Blanca", "usado"));
  }

  @Override
  public Product getProductById(Integer idProduct) {
    return products.stream().filter(x -> x.getProductId().equals(idProduct)).findFirst().orElse(null);
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
  @Override
  public Product createProductPromo(ProductCreatePromoDTO productCreatePromoDTO) {
    Boolean SuccessValidate = validateFieldsPromo(productCreatePromoDTO);
    if (!SuccessValidate) return null;

    Product product = new Product(productCreatePromoDTO.getProductId(),
            productCreatePromoDTO.getProductName(),
            productCreatePromoDTO.getType(),
            productCreatePromoDTO.getBrand(),
            productCreatePromoDTO.getColor(),
            productCreatePromoDTO.getNotes());
    return product;
  }

  private Boolean validateFieldsPromo(ProductCreatePromoDTO productCreatePromoDTO) {
    return productCreatePromoDTO.getProductId() != null &&
            productCreatePromoDTO.getProductName() != null &&
            productCreatePromoDTO.getType() != null &&
            productCreatePromoDTO.getBrand() != null &&
            productCreatePromoDTO.getColor() != null &&
            productCreatePromoDTO.getNotes() != null;
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
