package com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromo extends Post{

    private boolean hasPromo;
    private double discount;
    public PostPromo(int postId, User user, LocalDate date, int category, double price, Product product, boolean hasPromo, double discount) {
        super(postId, user, date, category, price, product);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
