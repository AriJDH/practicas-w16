package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoResDTO {
    private Integer userId;
    private String postId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductResDTO product;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;
}
