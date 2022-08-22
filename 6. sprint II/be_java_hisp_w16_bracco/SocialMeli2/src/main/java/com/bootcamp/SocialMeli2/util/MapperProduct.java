package com.bootcamp.SocialMeli2.util;

import com.bootcamp.SocialMeli2.dto.response.ResponsePostDto;
import com.bootcamp.SocialMeli2.dto.response.ResponseProductDto;
import com.bootcamp.SocialMeli2.entity.User;
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
