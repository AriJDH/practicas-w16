package com.bootcamp.be_java_hisp_w16_g10.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostReqDTO {
    private Integer user_id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductReqDTO product;
    private Integer category;
    private Double price;
}
