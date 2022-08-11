package com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class PromoProductPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromoProductPost(int postId, User user, LocalDate date, int category, double price, Product product, boolean hasPromo, double discount) {
        super(postId, user, date, category, price, product);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoProductPost(boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
