package com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response;


import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.User;
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
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoProductPostDto extends PostDto {

    public PromoProductPostDto(int userId, LocalDate date, ProductDto product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoProductPostDto(boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    private boolean hasPromo;
    private double discount;

}
