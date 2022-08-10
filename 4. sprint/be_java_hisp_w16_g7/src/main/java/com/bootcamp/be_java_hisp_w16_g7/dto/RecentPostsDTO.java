package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentPostsDTO {

    @JsonProperty("user_id")
    private int userID;

    @JsonProperty("posts")
    private List<ResponsePostDTO> responsePostDTOS;

}
