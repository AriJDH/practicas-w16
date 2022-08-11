package com.example.be_java_hisp_w16_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO {

    private Integer userId;
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public boolean validate() {
        return this.userId != null && this.date != null && this.product.validate() && this.category != null && this.price != null && this.discount != null;
    }


}
