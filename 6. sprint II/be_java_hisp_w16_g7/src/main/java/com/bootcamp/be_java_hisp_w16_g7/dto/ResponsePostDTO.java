package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostDTO {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("post_id")
    private int postId;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("product")
    private ProductDTO product;

    @JsonProperty("category")
    private int category;

    @JsonProperty("price")
    private double price;

}
