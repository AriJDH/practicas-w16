package com.example.be_java_hisp_w16_g09.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotedPost extends Post {

    private boolean hasPromo;
    private Double discount;

    public boolean isPromo() {
        return hasPromo;
    }

}
