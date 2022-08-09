package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResDTO {
    private Integer user_id;
    private Integer post_id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductResDTO product;
    private Integer category;
    private Double price;
}
