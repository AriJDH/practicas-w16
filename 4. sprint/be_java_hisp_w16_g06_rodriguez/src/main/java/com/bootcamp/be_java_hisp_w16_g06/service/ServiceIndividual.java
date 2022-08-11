package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.CountPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.UserDTO;
import com.bootcamp.be_java_hisp_w16_g06.entity.Post;
import com.bootcamp.be_java_hisp_w16_g06.entity.Product;
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

            cantidadPromo = postRepository.getPosts().stream().filter(x -> x.isHasPromo() && x.getUserId().equals(userId)).collect(Collectors.toList()).size();
            CountPromotionDTO countPromotionDTO = new CountPromotionDTO(userId, userDTO.getUserName(), cantidadPromo);

            return countPromotionDTO;

        }
        return null;

    }

}
