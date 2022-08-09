package com.example.be_java_hisp_w16_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostWithIDDTO {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private ProductDTO productDTO;
    private Integer category;
    private Double price;
}
