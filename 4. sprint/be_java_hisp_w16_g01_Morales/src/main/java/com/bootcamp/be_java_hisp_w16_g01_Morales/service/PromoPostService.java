package com.bootcamp.be_java_hisp_w16_g01_Morales.service;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.ProductDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;
import com.bootcamp.be_java_hisp_w16_g01_Morales.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01_Morales.repository.IPromoPostRepository;
import com.bootcamp.be_java_hisp_w16_g01_Morales.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromoPostService implements IPromoPostService{
    @Autowired
    private IPromoPostRepository promoPostRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public int createPromoPost(PromoPostDTO promoPostDTO) {
        validatePromoPostDto(promoPostDTO);


        ProductDto productDto = promoPostDTO.getProduct();
        Product product = new Product(productDto.getProductId(),
                productDto.getProductName(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes());
        PromoPost promoPost = new PromoPost(0, promoPostDTO.getUserId(),
                promoPostDTO.getDate(),
                product,
                promoPostDTO.getCategory(),
                promoPostDTO.getPrice(), promoPostDTO.isHasPromo(),promoPostDTO.getDiscount()
        );


        int id = promoPostRepository.CreatePromoPost(promoPost);
        promoPost.setPromoPostId(id);
        userRepository.getUser(promoPostDTO.getUserId()).addPromoPost(promoPost);

        return id;
    }

    @Override
    public List<PromoPost> getPromoPostsByUserId(int userId) {

        return promoPostRepository.getPromoPostsByUserId(userId);
    }

    @Override
    public CountPromoPostDTO countPromoPost(int userId) {

        return promoPostRepository.countPromoPost(userId);
    }

    public void validatePromoPostDto(PromoPostDTO promoPostDTO){

        if(!userRepository.userExists(promoPostDTO.getUserId()))
            throw new BadRequestException("No existe el usuario con Id: " + promoPostDTO.getUserId());
    }
}
