package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.FailedToCreateResource;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IPublicationRepository iPublicationRepository;

    private final ModelMapper mapper ;
    public ProductService() {
        mapper =  new ModelMapper();
    }

    @Override
    public ProductDTO getProductById(Integer idProduct) {
        Product product = iProductRepository.getProductById(idProduct);
        return mapper.map(product, ProductDTO.class);
    }



    @Override
    public String CreateProduct(RequestCreatePublicationDTO productCreateDTO) {

        //Create product
         Product product = iProductRepository.createProduct(productCreateDTO.getProduct());

         if(product == null){
             throw new FailedToCreateResource("Bad request");
         }

        //Create publication
        PublicationDTO publicationDTO = new PublicationDTO(productCreateDTO.getUserId(),
                productCreateDTO.getDate(),
                productCreateDTO.getCategory(),
                productCreateDTO.getPrice(),
                productCreateDTO.getProduct().getProductId() );

        var isCreatedPublication = iPublicationRepository.createPublication(publicationDTO);

        if (isCreatedPublication == null){
            throw new FailedToCreateResource("Bad request");
        }
        return "Todo ok";
    }
}
