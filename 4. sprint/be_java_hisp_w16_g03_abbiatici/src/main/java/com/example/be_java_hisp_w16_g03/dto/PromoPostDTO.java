package com.example.be_java_hisp_w16_g03.dto;

import com.example.be_java_hisp_w16_g03.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO {

    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public boolean validate() {
        return this.userId != null && this.date != null
                && this.product.validate() && this.category != null &&
                this.price != null && this.hasPromo != null
                && this.discount != null;
    }

}
