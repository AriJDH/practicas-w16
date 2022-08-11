package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.exception.FailedToCreateResource;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This service takes care of all matters related to products
 */
@Service
public class ProductService implements IProductService {

  @Autowired
  IProductRepository iProductRepository;
  @Autowired
  IPublicationRepository iPublicationRepository;

  @Autowired
  IUserRepository iUserRepository;

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

    Boolean haspromo = false;
    Double discount = 0.0;

    //Create product
    Product product = iProductRepository.createProduct(productCreateDTO.getProduct());

    if (product == null) {
      throw new FailedToCreateResource("Bad request");
    }

    if(productCreateDTO.getHasPromo()!= null ){
      haspromo = true;
      discount = productCreateDTO.getDiscount();

    }

    //Create publication
    PublicationDTO publicationDTO = new PublicationDTO(productCreateDTO.getUserId(),
        productCreateDTO.getDate(),
        productCreateDTO.getCategory(),
        productCreateDTO.getPrice(),
        productCreateDTO.getProduct().getProductId(),
            haspromo, discount);

    var isCreatedPublication = iPublicationRepository.createPublication(publicationDTO);

    if (isCreatedPublication == null) {
      throw new FailedToCreateResource("Bad request");
    }
    return new ResponseApiDTO("Success", "All ok");
  }

  /**
   * Count the number of products in promotion of a seller id
   * @param userId of the User
   * @return RequestCountProductPromo List of Products
   */
  @Override
  public RequestCountProductPromo countProduct(Integer userId) {

    User user = iUserRepository.getByIdUser(userId);
    Integer count = Math.toIntExact(iPublicationRepository.getListPublicationsById(userId)
            .stream().filter(Publication::getHasPromo).count());

    if (user == null)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);

    return new RequestCountProductPromo(user.getUserId(), user.getUserName(), count);
  }

  /**
   *  List the products in promotion of a user
   * @param userId of the User
   * @return ResponseListPromoDTO List of Products
   */
  @Override
  public ResponseListPromoDTO listProductPromo(Integer userId) {

    User user = iUserRepository.getByIdUser(userId);

    List<PostDTO> posts = iPublicationRepository.getListPublicationsById(userId)
            .stream().filter(Publication::getHasPromo)
            .map(p -> new PostDTO(p.getUserId(), p.getPublicationId(),
                    p.getDate(), mapper.map(iProductRepository.getProductById(p.getProductId()), ProductDTO.class),
                    p.getCategory(), p.getPrice(), p.getHasPromo(), p.getDiscount())).collect(Collectors.toList());

    if (user == null)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);

    return new ResponseListPromoDTO(user.getUserId(), user.getUserName(), posts);
  }
}
