package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentPostsDTO {

    @JsonProperty("user_id")
    private int userID;

    @JsonProperty("posts")
    private List<ResponsePostDTO> responsePostDTOS;

}
