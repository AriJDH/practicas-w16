package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.FailedToCreateResource;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.stereotype.Service;

/**
 * This service takes care of all matters related to products
 */
@Service
public class ProductService implements IProductService {

  @Autowired
  IProductRepository iProductRepository;
  @Autowired
  IPublicationRepository iPublicationRepository;

  private final ModelMapper mapper;

  public ProductService() {
    mapper = new ModelMapper();
  }

  /**
   * Method that returns me DTO of product given its id
   * @param idProduct It is the product id
   * @return Product DTO
   */
  @Override
  public ProductDTO getProductById(Integer idProduct) {
    Product product = iProductRepository.getProductById(idProduct);
    return mapper.map(product, ProductDTO.class);
  }


  /**
   * Method in charge of creating a product and at the same time creating a publication
   * @param productCreateDTO Contains the DTO of the publication and the product
   * @return DTO with a response for the user
   */
  @Override
  public ResponseApiDTO CreateProduct(RequestCreatePublicationDTO productCreateDTO) {
    Boolean hasPromo = false;
    Double discount = 0.0;
    if (productCreateDTO.getHasPromo() != null) {
      hasPromo = true;
      discount = productCreateDTO.getDiscount();
    }
    //Create product
    Product product = iProductRepository.createProduct(productCreateDTO.getProduct());

    if (product == null) {
      throw new FailedToCreateResource("Bad request");
    }

    //Create publication
    PublicationDTO publicationDTO = new PublicationDTO(productCreateDTO.getUserId(),
        productCreateDTO.getDate(),
        productCreateDTO.getCategory(),
        productCreateDTO.getPrice(),
        productCreateDTO.getProduct().getProductId(), hasPromo, discount);

    var isCreatedPublication = iPublicationRepository.createPublication(publicationDTO);

    if (isCreatedPublication == null) {
      throw new FailedToCreateResource("Bad request");
    }
    return new ResponseApiDTO("Success", "All ok");
  }
}
