package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.*;
import com.bootcamp.be_java_hisp_w16_g06.entity.Post;
import com.bootcamp.be_java_hisp_w16_g06.entity.Product;
import com.bootcamp.be_java_hisp_w16_g06.exceptions.CategoryException;
import com.bootcamp.be_java_hisp_w16_g06.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceIndividual implements IServiceIndividual{

    @Autowired
    ISocialMeliServiceE1 socialMeliServiceE1;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ISocialMeliServiceE2 socialMeliServiceE2;

    @Override
    public void registerPostPromotion(RequestPostPromotionDTO requestPostPromotionDTO) {

        //Primero valida que el usuario exista consumiento del otro servicio esa búsqueda
        if (socialMeliServiceE1.findById(requestPostPromotionDTO.getUser_id())) {

            List<Post> listRepository = postRepository.getPosts();
            listRepository.add(postPromotionDTOToPostEntity(requestPostPromotionDTO));
            postRepository.setPosts(listRepository);

        }

    }


    private Post postPromotionDTOToPostEntity(RequestPostPromotionDTO requestPostPromotionDTO) {

        Product product = new Product(requestPostPromotionDTO.getProduct().getProduct_id(), requestPostPromotionDTO.getProduct().getProduct_name(), requestPostPromotionDTO.getProduct().getType(), requestPostPromotionDTO.getProduct().getBrand(), requestPostPromotionDTO.getProduct().getColor(), requestPostPromotionDTO.getProduct().getNotes());

        DateTimeFormatter convertionDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(requestPostPromotionDTO.getDate(), convertionDate);

        return new Post(product, requestPostPromotionDTO.getUser_id(), postRepository.getCorrelativo(), localDate, requestPostPromotionDTO.getCategory(), requestPostPromotionDTO.getPrice(), requestPostPromotionDTO.isHasPromo(), requestPostPromotionDTO.getDiscount());
    }

    @Override
    public CountPromotionDTO getCountPromotionDTO(int userId){

        if (socialMeliServiceE1.findById(userId)) {

            int cantidadPromo = 0;
            UserDTO userDTO = socialMeliServiceE2.findById(userId).stream().findFirst().get();

            cantidadPromo = postRepository.getPosts().stream()
                    .filter(x -> x.isHasPromo() && x.getUserId().equals(userId))
                    .collect(Collectors.toList()).size();

            CountPromotionDTO countPromotionDTO = new CountPromotionDTO(userId, userDTO.getUserName(), cantidadPromo);

            return countPromotionDTO;

        }
        return null;

    }

    @Override
    public ListProductDTO getProductByCategory(int idCategory) {

        List<Product> listProduct;

        listProduct = postRepository.getPosts().stream().filter(x -> x.getCategory() == idCategory)
                .map(y->{
                    Product product;
                    product = y.getProduct();
                    return product;
                }).collect(Collectors.toList());

        if(listProduct.isEmpty()) {
            throw new CategoryException("Category not found or without products");
        } else {

            ListProductDTO listProductDTO = new ListProductDTO(ProductToListProductDTO(listProduct));

            return listProductDTO;
        }



    }

    private List<ProductDTO> ProductToListProductDTO(List<Product> listProduct) {

        return listProduct.stream().map(x->{
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProduct_id(x.getProductId());
            productDTO.setProduct_name(x.getProductName());
            productDTO.setNotes(x.getNote());
            productDTO.setType(x.getType());
            productDTO.setColor(x.getColor());
            productDTO.setBrand(x.getBrand());

            return productDTO;
        }).collect(Collectors.toList());


    }

}
