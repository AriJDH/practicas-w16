package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.repositories.*;
import org.modelmapper.ModelMapper;
import com.bootcamp.be_java_hisp_w16_g04.exception.FailedToCreateResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This service takes care of all matters related to products
 */
@Service
public class ProductService implements IProductService {

  private final IProductRepository iProductRepository;
  private final IPublicationRepository iPublicationRepository;
  private final IUserRepository iUserRepository;


  private final ModelMapper mapper;

  public ProductService(ProductRepository productRepository, PublicationRepository publicationRepository, UserRepository userRepository) {
    mapper = new ModelMapper();
    this.iProductRepository = productRepository;
    this.iPublicationRepository = publicationRepository;
    this.iUserRepository = userRepository;
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
  public ResponseApiDTO createProduct(RequestCreatePublicationDTO productCreateDTO) {

    createProduct(productCreateDTO.getProduct());

    PublicationDTO publicationDTO = new PublicationDTO(
            productCreateDTO.getUserId(),
            productCreateDTO.getDate(),
            productCreateDTO.getCategory(),
            productCreateDTO.getPrice(),
            productCreateDTO.getProduct().getProductId(),
            false,
            0.0);

    createPublication(publicationDTO);

    return new ResponseApiDTO("Ok", "Post created");
  }

  @Override
  public ResponseApiDTO createProduct(RequestCreatePublicationDiscountDTO publicationDiscountDTO) {

    createProduct(publicationDiscountDTO.getProduct());

    PublicationDTO publicationDTO = new PublicationDTO(
            publicationDiscountDTO.getUserId(),
            publicationDiscountDTO.getDate(),
            publicationDiscountDTO.getCategory(),
            publicationDiscountDTO.getPrice(),
            publicationDiscountDTO.getProduct().getProductId(),
            publicationDiscountDTO.getHasPromo(),
            publicationDiscountDTO.getDiscount());

    createPublication(publicationDTO);

    return new ResponseApiDTO("Ok", "Post created with discount");
  }

  @Override
  public ResponseCountDiscountDTO countProductsDiscountByUserId(Integer userId) {

    iUserRepository.isValidUser(userId);
    String nameUser = iUserRepository.getByIdUser(userId).getUserName();
    Integer countPublications = (int) iPublicationRepository.getListPublicationsById(userId)
            .stream().filter(Publication::getHasPromo).count();

    return new ResponseCountDiscountDTO(userId, nameUser, countPublications);
  }

  @Override
  public ResponseListDiscountDTO listProductsDiscountByUserId(Integer userId) {

    iUserRepository.isValidUser(userId);
    String nameUser = iUserRepository.getByIdUser(userId).getUserName();

    List<PostDTO> publications = iPublicationRepository.getListPublicationsById(userId)
            .stream().filter(Publication::getHasPromo)
            .map(p -> new PostDTO(p.getUserId(), p.getPublicationId(),
                    p.getDate(), mapper.map(iProductRepository.getProductById(p.getProductId()), ProductDTO.class),
                    p.getCategory(), p.getPrice(), p.getHasPromo(), p.getDiscount())).collect(Collectors.toList());

    return new ResponseListDiscountDTO(userId, nameUser, publications);
  }

  private void createProduct(ProductDTO product) {
    if (product == null) {
      throw new FailedToCreateResource("Not Found Data");
    }

    Product result = iProductRepository.createProduct(mapper.map(product, Product.class));

    if (result == null)  {
      throw new FailedToCreateResource("The product was not created");
    }
  }


  public void createPublication(PublicationDTO publicationDto) {

    if (publicationDto == null) {
      throw new FailedToCreateResource("Not Found Data");
    }

    Publication publication = new Publication(
            0,
            publicationDto.getUserId(),
            publicationDto.getDate(),
            publicationDto.getProductId(),
            publicationDto.getCategory(),
            publicationDto.getPrice(),
            publicationDto.getHasPromo(),
            publicationDto.getDiscount()
    );

    Publication result = iPublicationRepository.createPublication(publication);

    if (result == null) {
      throw new FailedToCreateResource("The publication was not created");
    }
  }

}
