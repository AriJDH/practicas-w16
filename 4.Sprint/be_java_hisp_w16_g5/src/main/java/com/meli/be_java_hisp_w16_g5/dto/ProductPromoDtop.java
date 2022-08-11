package com.meli.be_java_hisp_w16_g5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoDtop {

    private int userId;
    private String userName;
    private int promoProductsCount;

}
