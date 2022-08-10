package com.example.be_java_hisp_w16_g03.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    

    public boolean validate() {
        return this.productId != null && this.type != null
                && this.notes != null && this.color != null
                && this.brand != null && this.productName != null
                && !this.type.isEmpty() && !this.notes.isEmpty()
                && !this.color.isEmpty() && !this.brand.isEmpty()
                && !this.productName.isEmpty();
    }

}
