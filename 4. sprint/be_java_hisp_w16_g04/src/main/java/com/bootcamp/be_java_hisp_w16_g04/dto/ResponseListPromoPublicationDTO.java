package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class ResponseListPromoPublicationDTO extends UserDTO{
    private List<PromoPublicationDTO> posts;
    public ResponseListPromoPublicationDTO(Integer userId, String userName,  List<PromoPublicationDTO> posts ){
        super(userId,userName);
        this.posts = posts;

    }
}
