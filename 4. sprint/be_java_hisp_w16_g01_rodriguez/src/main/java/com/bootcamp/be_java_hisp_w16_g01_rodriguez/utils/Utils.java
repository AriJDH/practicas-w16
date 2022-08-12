package com.bootcamp.be_java_hisp_w16_g01_rodriguez.utils;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.exception.BadRequestException;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

public class Utils {

    public Product mapProductDto(ProductDTO productDto){
        return new Product(
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes()
        );
    }

    public ProductDTO mapProduct(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public PromoPostDTO mapPromoPost(Post post){
        return new PromoPostDTO(
                post.getUserId(),
                post.getDate(),
                mapProduct(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public ResponsePostDTO mapPost(Post post){
        return new ResponsePostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getDate(),
                mapProduct(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }

    public void validatePostDto(PostDTO postDto){
        if (postDto.getDate() == null)
            throw new BadRequestException("La fecha es un campo obligatorio");

        if (postDto.getDate().isAfter(LocalDate.now()))
            throw new BadRequestException("La fecha es posterior a la fecha actual");
    }

    public void validatePromo(PromoPostDTO postDto){
        if(!postDto.isHasPromo() && postDto.getDiscount() > 0)
            throw new BadRequestException("Solo las publicaciones en promo llevan descuento");

        if(postDto.getDiscount() > 100 || postDto.getDiscount() < 0)
            throw new BadRequestException("El descuento debe ser un numero entre 0 y 100");
    }
}
