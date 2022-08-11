package com.bootcamp.be_java_hisp_w16_g08_bracco.util;

import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.ResponsePostDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.ResponseProductDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entiry.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperProduct {
    public List<ResponsePostDto> mapUserPostDto(List<User> users) {
        List<ResponsePostDto> response = new ArrayList<>();
        users.forEach(user -> {
            user.getPostMade().forEach(x -> {
                ResponseProductDto productDto = new ResponseProductDto(
                        x.getProduct().getId(),
                        x.getProduct().getName(),
                        x.getProduct().getType(),
                        x.getProduct().getBrand(),
                        x.getProduct().getColor(),
                        x.getProduct().getNotes());
                response.add(
                        new ResponsePostDto(x.getPostId(),
                                x.getUser().getUserId(),
                                x.getDate(),
                                productDto,
                                x.getPrice(),
                                x.getCategory()));
            });
        });

        return response;

    }

}
