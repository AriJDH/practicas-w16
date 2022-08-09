package com.example.be_java_hisp_w16_g03.dto;

import com.example.be_java_hisp_w16_g03.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Integer userId;
    private LocalDate date;
    private ProductDTO productDTO;
    private Integer category;
    private Double price;
}
